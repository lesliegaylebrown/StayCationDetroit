package com.company.controller;


import com.company.model.DAO;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by kamel on 7/13/2016
 * and Peter on 8/15/2017
 * JAVA DREAM TEAM
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String Home() {

        return "index";// or views/test
    }

    @RequestMapping(value = "/userForm")
    public String userForm() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "userForm";
    }


    //handle the submit of the customer form
    @RequestMapping(value = "/addUser")
    public ModelAndView addCustomer(
            @RequestParam("userId") String userId,
            @RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("cphone") String cPhone,
            @RequestParam("password") String password
    )
    {
        {
            StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
            String passEncryted = enc.encryptPassword(password);

            password = passEncryted;

        }

        //add the info to DB through DAO
        boolean result = DAO.addUser(userId, fName, lName, email, cPhone, password);
        //best to check the result
        if (!result) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "user login failed");
        }

        ModelAndView mv = new ModelAndView("addUserResult");
        mv.addObject("UserId", userId);
        mv.addObject("FirstName", fName);
        mv.addObject("LastName", lName);
        mv.addObject("Email", email);
        mv.addObject("CellPhone", cPhone);
        mv.addObject("Password", password);

        return mv;
    }

    @RequestMapping(value = "getAllUsers")
    public ModelAndView getAllUsers(){
        ArrayList<User> userList = DAO.getUserList();

        //TODO make error.jsp
        if (userList == null){
            return new ModelAndView("error", "errmsg","User list is null");
        }
        return new ModelAndView("delUserView","uList","userList");
    }
    @RequestMapping(value = "deleteUser")
    public String deleteUser (Model model,@RequestParam("userId")String userId){

        //make it happen at the DB
        boolean result = DAO.deleteUser(userId);

        if (!result){
            model.addAttribute("errmsg", "Delete failed");
            return "error";
        }

        // adding info without a ModelAndView
        //get the model as an argument above
        // and add to it
        model.addAttribute("userId", userId);
        return "/views/deletedUserResult";
    }
    @RequestMapping(value = "login")
    public String login() {
        // if a controller method returns just a String
        // Spring MVC know's it is a view name
        return "userLogin";
    }
    /*@RequestMapping(value = "/checklogin")
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
            return new ModelAndView("error", "errmsg", "user login failed");
        }
    */



    @RequestMapping(value = "outdoorsresponse")
    public ModelAndView outdoorsresponse(){ return new ModelAndView("outdoorsresponse");}

        @RequestMapping(value = "outdoors")
    public ModelAndView outdoors(){return new ModelAndView("outdoors");}

    @RequestMapping(value = "nightsresponse")
    public ModelAndView nightsresponse(){return new ModelAndView("nightsresponse");}

    @RequestMapping(value = "nights")
    public ModelAndView nights(){ return new ModelAndView("nights");}

    @RequestMapping(value = "goodbye")
    public ModelAndView goodbye(){return new ModelAndView("goodbye");}

    @RequestMapping(value = "eatsresponse")
    public ModelAndView eatsresponse(){ return new ModelAndView("eatsresponse");}

    @RequestMapping(value = "eats")
    public ModelAndView eats(){ return new ModelAndView("eats");}

    @RequestMapping(value ="categories")
    public ModelAndView categories(){ return new ModelAndView("categories()");}


    @RequestMapping(value = "buildings")
    public ModelAndView buildings() {
        return new ModelAndView("buildings");
    }

    @RequestMapping(value = "buildresponse")
    public ModelAndView buildresponse(){ return new ModelAndView("buildresponse");
    }






    }
