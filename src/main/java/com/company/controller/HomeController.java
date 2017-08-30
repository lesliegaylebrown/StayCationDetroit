package com.company.controller;

import com.company.model.*;

import com.sun.jndi.toolkit.url.Uri;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import org.jasypt.util.password.StrongPasswordEncryptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String Home() {
        return "index";// or views/test
    }


    //    This method takes the onclick request from the index page button "Registration" and calls the page
//    CreateAccount.jsp
    @RequestMapping(value = "CreateAccount")
    public String CreateAccount() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "CreateAccount";
    }


    //handle the submit of the user form, user input validation, and user password encryption
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(
            @RequestParam("userId") String userId,
            @RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("Cphone") String cPhone,
            @RequestParam("password") String password

    ) {
//        this code calls the validation methods for each registration field
        boolean goodUserid = Validation.validateUserId(userId);
        if (!goodUserid) {
            return new ModelAndView("error", "errmsg", "Invalid User ID");
        }
        boolean goodfName = Validation.validateEntry(fName);
        if (!goodfName) {
            return new ModelAndView("error", "errmsg", "Invalid Name");
        }
        boolean goodlName = Validation.validateEntry(lName);
        if (!goodlName) {
            return new ModelAndView("error", "errmsg", "Invalid Name");
        }
        boolean goodemail = Validation.validateEmail(email);
        if (!goodemail) {
            return new ModelAndView("error", "errmsg", "Invalid email");
        }
        boolean goodcPhone = Validation.validatePhoneNumber(cPhone);
        if (!goodcPhone) {
            return new ModelAndView("error", "errmsg", "Invalid phone number");
        }

        boolean goodpassword = Validation.validatePassword(password);
        if (!goodpassword) {
            return new ModelAndView("error", "errmsg", "Invalid password");
        }
//sends password to method to encrypt using jasypt-StrongPasswordEncryptor
        password = Validation.encryptPassword(password);

        //add the info to DBase through DAO (Data Access Object Class)
        boolean result = DAO.addUser(userId, fName, lName, email, cPhone, password);
        //check the result, if false sends the error code message from "modelObject:" to error.jsp to view
        if (!result) {

            return new ModelAndView("error", "errmsg", "user add failed");
        }
//Creates Expression Language objects that link to the values of the objects below
        ModelAndView mv = new ModelAndView("/addUserResult");
        mv.addObject("UserId", userId);
        mv.addObject("FirstName", fName);
        mv.addObject("LastName", lName);
        mv.addObject("Email", email);
        mv.addObject("CellPhone", cPhone);
        mv.addObject("Password", password);

        return mv;
    }

//this is an optional method that allows an admin to delete users,
// or to allow the user to delete their account using delUserView

    @RequestMapping(value = "getAllUsers")
    public ModelAndView getAllUsers() {
        ArrayList<User> userList = DAO.getUserList();


        if (userList == null) {
            return new ModelAndView("error", "errmsg", "User list is null");
        }

        return new ModelAndView("delUserView", "uList", userList);
    }


//    method to display all buildings etc... from the attractions Dbase

    @RequestMapping(value = "getAllBuildings")
//
    public ModelAndView getAllBuildings() {

//        Calls getBuildingList run a SQL query to populate the buildingList for use in buildingView.jsp
        ArrayList<Building> buildingList = DAO.getBuildingList();

        if (buildingList == null) {
            return new ModelAndView("error", "errmsg", "Building list is null");
        }
//sends data for display in the buildingView.jsp as a html table
        return new ModelAndView("buildingView", "buildingList", buildingList);

    }

    //    this method is called as an option to delete users in the getAllUser JSP
    @RequestMapping("deleteUser")
    public String deleteUser(
            Model model,
            @RequestParam("userId") String userId) {
        //make it happen with the DB
        boolean result = DAO.deleteUser(userId);

        if (!result) {
            model.addAttribute("errmsg", "Delete failed");
            return "error";
        }
        //adding info without a ModelAndView
        //get the model as a argument above
        //and add to it
        model.addAttribute("userId", userId);
        return "deletedUserResult";
    }

    @RequestMapping("/restaurant")
//Requests the value of the LatandLon parameter
    public ModelAndView Restaurants(@RequestParam("LatandLon") String LatandLon

//   Assembles a URI data type by combining String data from the buildingView page

// satisfies requirement to include an exception for the URI data type
    ) throws URISyntaxException {
        String latLon = LatandLon;
        String test1 = "https://developers.zomato.com/api/v2.1/search?entity_type=metro&start=0&count=100&";
        String test2 = "&radius=160&sort=real_distance&order=asc";
        String test3 = test1 + latLon + test2;
        URI myuri = new URI(test3);

        try {
//              Allows access to JSON file
            HttpClient http = HttpClientBuilder.create().build();
//              uses newly created myURI as the address to the JSON/Zomato server
            HttpGet getPage = new HttpGet(myuri);
//               used to request access to the JSON/Zomato file
            getPage.addHeader("accept", "application/json");
//                sends the provided API key to the JSON/Zomato server, the Key is hidden in the
//                APICredentials this file is listed on the .gitignore file to be excluded from the github repository
            getPage.addHeader("user-key", APICredentials.API_KEY);
//              Retrieves result of the request sent with API key
            HttpResponse resp = http.execute(getPage);
//              copies result into jsonString
            String jsonString = EntityUtils.toString(resp.getEntity());

            //turn it into java actual JSON object

            JSONObject json = new JSONObject(jsonString);
//              imports json.getJSONArray so that we can pull the information we want to use
            JSONArray rest = json.getJSONArray("restaurants");
//          Creates an Array list to store the results from the objects we create from the json array
            ArrayList<Restaurants> restList = new ArrayList<Restaurants>();
//           "for loop" to pull the name, url, address etc... from JSONArray for each eatery found in the search (160 meter perimeter)
            for (int i = 0; i < rest.length(); i++) {

                String rest1N = json.getJSONArray("restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                        ("name");
                String rest1U = json.getJSONArray("restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                        ("url");
                String rest1L = json.getJSONArray("restaurants").getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString
                        ("address");
                String rest1Cuis = json.getJSONArray("restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                        ("cuisines");
                String rest1AvgCst = json.getJSONArray("restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                        ("average_cost_for_two");
// creates object of the values pulled from the JSONArray to add to restList
                Restaurants temp = new Restaurants(rest1N, rest1L, rest1Cuis, rest1AvgCst, rest1U);
                restList.add(temp);
            }
            ModelAndView mv = new ModelAndView("Restaurants");
// creates String object that includes latitude & longitude, formatted for use in the URI,
// to get the list of eateries (in range of the QLine stops) This was pulled from the buildingView.jsp form
            mv.addObject("LatandLon", LatandLon);
//          creates the object rList for use in displaying its contents in the Restaurants.jsp table
            mv.addObject("rList", restList);
            return mv;

//            these two exceptions are formatted to output the specific errors generated to the console
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;

    }

//    when the Login button on the index and other pages is clicked, it uses this method to call the
//    userLogin.jsp form to authenticate entry
    @RequestMapping(value = "login")
    public String login() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "userLogin";
    }
//
    @RequestMapping(value = "/checklogin")
    public ModelAndView login(
            @RequestParam("userId")
                    String userId,

            @RequestParam("password")
                    String password
    ) {

        //checks the info against the DB login and password, through DAO
        boolean result = DAO.login(userId, password);

        //if false calls error page
        if (!result) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "User Login Failed");
        }
//         sends authenticated user to Home/Main page
        ModelAndView mv = new ModelAndView("Welcome");

        return mv;

    }

}


