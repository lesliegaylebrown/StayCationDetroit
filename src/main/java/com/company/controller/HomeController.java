package com.company.controller;



import com.company.model.APICredentials;
import com.company.model.DAO;

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
import java.util.ArrayList;




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
    public ModelAndView addUser (
            @RequestParam("userId") String userId,
            @RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("Cphone") String cPhone,
            @RequestParam("password") String password
    ) {


        StrongPasswordEncryptor enc = new StrongPasswordEncryptor();

        String passEncrypted = enc.encryptPassword(password);

        password = passEncrypted;

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

    @RequestMapping(value = "buildings")
    public ModelAndView buildings(){
        return new ModelAndView("buildings");
    }

    @RequestMapping(value = "getAllUsers")
    public ModelAndView getAllUsers() {
        ArrayList<User> userList = DAO.getUserList();

        //TODO: make error.jsp
        if (userList == null) {
            return new ModelAndView("error", "errmsg", "User list is null");
        }

        return new ModelAndView("delUserView","uList",userList);
    }

    @RequestMapping("deleteUser")
    public String deleteUser (
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
        return "/views/deletedUserResult";
    }

    @RequestMapping("/restaurant")
    public ModelAndView Restaurants() {
        try {
            System.out.println("Entered restaurant controller");
            HttpClient http = HttpClientBuilder.create().build();

            HttpGet getPage = new HttpGet("https://developers.zomato.com/api/v2.1/geocode?lat=42.336167&lon=-83.049861");
            getPage.addHeader("accept", "application/json");
            getPage.addHeader("user-key", APICredentials.API_KEY);

            HttpResponse resp = http.execute(getPage);


            String jsonString = EntityUtils.toString(resp.getEntity());

            //turn it unto java actual JSON object

            JSONObject json = new JSONObject(jsonString);

            String rest1N = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("name");
            String rest1U = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("url");
            String rest1L = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getJSONObject("location").getString
                    ("address");
            String rest1Cuis = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("cuisines");
            String rest1AvgCst = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("average_cost_for_two");
            String rest2 = json.getJSONArray("nearby_restaurants").getJSONObject(0).toString();
            JSONArray rest3 = json.getJSONArray("nearby_restaurants");

            String rest2N = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("name");
            String rest2U = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("url");
            String rest2L = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getJSONObject("location").getString
                    ("address");
            String rest2Cuis = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("cuisines");
            String rest2AvgCst = json.getJSONArray("nearby_restaurants").getJSONObject(0).getJSONObject("restaurant").getString
                    ("average_cost_for_two");

            ModelAndView mv = new ModelAndView("Restaurants");
            mv.addObject("JSONstring", json.toString());
            mv.addObject("rest1N",rest1N);
            mv.addObject("rest1U", rest1U);
            mv.addObject("rest1L", rest1L);
            mv.addObject("rest1Cuis",rest1Cuis);
            mv.addObject("rest1AvgCst",rest1AvgCst);

            mv.addObject("rest2N",rest1N);
            mv.addObject("rest2U", rest1U);
            mv.addObject("rest2L", rest1L);
            mv.addObject("rest2Cuis",rest1Cuis);
            mv.addObject("rest2AvgCst",rest1AvgCst);



            return mv;


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

    public ModelAndView login (
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

        ModelAndView mv = new ModelAndView("/buildings");

        return mv;
    }


}

