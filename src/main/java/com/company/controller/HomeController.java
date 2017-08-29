package com.company.controller;

import com.company.model.*;

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

    @RequestMapping(value = "CreateAccount")
    public String CreateAccount() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "CreateAccount";
    }

    //handle the submit of the user form
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(
            @RequestParam("userId") String userId,
            @RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("Cphone") String cPhone,
            @RequestParam("password") String password

    ) {
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

        password = Validation.encryptPassword(password);

        //add the info to DB through DAO
        boolean result = DAO.addUser(userId, fName, lName, email, cPhone, password);
        //check the result
        if (!result) {

            return new ModelAndView("error", "errmsg", "user add failed");
        }

        ModelAndView mv = new ModelAndView("/addUserResult");
        mv.addObject("UserId", userId);
        mv.addObject("FirstName", fName);
        mv.addObject("LastName", lName);
        mv.addObject("Email", email);
        mv.addObject("CellPhone", cPhone);
        mv.addObject("Password", password);

        return mv;
    }

    @RequestMapping(value = "getAllUsers")
    public ModelAndView getAllUsers() {
        ArrayList<User> userList = DAO.getUserList();

        //TODO: make error.jsp
        if (userList == null) {
            return new ModelAndView("error", "errmsg", "User list is null");
        }

        return new ModelAndView("delUserView", "uList", userList);
    }

    @RequestMapping(value = "getAllBuildings")
    public ModelAndView getAllBuildings()
    {

        ArrayList<Building> buildingList = DAO.getBuildingList();


        //TODO: make error.jsp
        if (buildingList == null) {
            return new ModelAndView("error", "errmsg", "Building list is null");
        }

        return new ModelAndView("buildingView", "buildingList", buildingList);


    }
public ModelAndView buildingObjects( @RequestParam("buildingId") String buildingId,
                                     @RequestParam("buildingName") String buildingName,
                                     @RequestParam("buildingAddress") String buildingAddress,
                                     @RequestParam("buildingDescription") String buildingDescription,
                                     @RequestParam("buildingImage") String buildingImage,
                                     @RequestParam("qlineStops") String qlineStops,
                                     @RequestParam("longitude") double longitude,
                                     @RequestParam("latitude") double latitude){
        ModelAndView mv = new ModelAndView(" ");

        mv.addObject("buildingId", buildingId);
        mv.addObject("buildingName", buildingName);
        mv.addObject("buildingAddress", buildingAddress);
        mv.addObject("buildingDescription", buildingDescription);
        mv.addObject("buildingImage", buildingImage);
        mv.addObject("qlineStops", qlineStops);
        mv.addObject("longitude", longitude);
        mv.addObject("latitude", latitude);
        return mv;}

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



        public ModelAndView Restaurants(@RequestParam("LatandLon") String LatandLon
//    @RequestParam("Long") double Long, @RequestParam("Lat") double Lat
    ) throws URISyntaxException {
            String latLon = LatandLon;
            String test1 = "https://developers.zomato.com/api/v2.1/geocode?";
            String test2 = test1 + latLon;
            URI myuri = new URI(test2);

            try {
                System.out.println("Entered restaurant controller");
                HttpClient http = HttpClientBuilder.create().build();

                // HttpGet getPage = new HttpGet("https://developers.zomato.com/api/v2.1/geocode?"+"LatandLon");
                HttpGet getPage = new HttpGet(myuri);
                getPage.addHeader("accept", "application/json");
                getPage.addHeader("user-key", APICredentials.API_KEY);

                HttpResponse resp = http.execute(getPage);

                String jsonString = EntityUtils.toString(resp.getEntity());

                //turn it unto java actual JSON object

                JSONObject json = new JSONObject(jsonString);

                JSONArray rest = json.getJSONArray("nearby_restaurants");

                ArrayList<Restaurants> restList = new ArrayList<Restaurants>();
                for (int i = 0; i < rest.length(); i++) {

                    String rest1N = json.getJSONArray("nearby_restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                            ("name");
                    String rest1U = json.getJSONArray("nearby_restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                            ("url");
                    String rest1L = json.getJSONArray("nearby_restaurants").getJSONObject(i).getJSONObject("restaurant").getJSONObject("location").getString
                            ("address");
                    String rest1Cuis = json.getJSONArray("nearby_restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                            ("cuisines");
                    String rest1AvgCst = json.getJSONArray("nearby_restaurants").getJSONObject(i).getJSONObject("restaurant").getString
                            ("average_cost_for_two");

                    Restaurants temp = new Restaurants(rest1N, rest1L, rest1Cuis, rest1AvgCst, rest1U);
                    restList.add(temp);
                }
                ModelAndView mv = new ModelAndView("Restaurants");

            mv.addObject("LatandLon", LatandLon);

            mv.addObject("rList", restList);
            return mv;
//            return new ModelAndView("Restaurants", "rList", restList);
//            Restaurants.addObject();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @RequestMapping(value = "login")
    public String login() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "userLogin";
    }

    @RequestMapping(value = "/checklogin")
    public ModelAndView login(
            @RequestParam("userId")
                    String userId,

            @RequestParam("password")
                    String password
    ) {

        //add the info to DB through DAO
        boolean result = DAO.login(userId, password);

        //best to check the result
        if (!result) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "User Login Failed");
        }

        ModelAndView mv = new ModelAndView("Welcome");

        return mv;

    }

}


