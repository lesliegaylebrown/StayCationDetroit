package com.company.controller;


import com.company.model.DAO;
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

    @RequestMapping(value = "userForm")
    public String userForm() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "userForm";
    }

//    *****************************************
//


    //handle the submit of the user form
    @RequestMapping(value = "addUser")
    public ModelAndView addUser (
            @RequestParam("userId") String userId,
            @RequestParam("fName") String fName,
        @RequestParam("lName") String lName,
        @RequestParam("email") String email,
        @RequestParam("Cphone") String cPhone,
        @RequestParam("password") String password
        ) {

        //add the info to DB through DAO
        boolean result = DAO.addUser(userId, fName, lName, email, cPhone, password);
        //best to check the result
        if (!result) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "user add failed");
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
}