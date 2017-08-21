package com.company.controller;


import com.company.model.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
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
        return "test";// or views/test
    }

    @RequestMapping(value = "/customerForm")
    public String customerForm() {
        //if a controller method returns just a String
        //Spring MVC knows it's a view name
        return "customerForm";
    }

    //handle the submit of the customer form
    @RequestMapping(value = "/addCustomer")
    public ModelAndView addCustomer (
        @RequestParam("CustomerID") String custID,
        @RequestParam("CompanyName") String compName,
        @RequestParam("ContactName") String contactName,
        @RequestParam("ContactTitle") String contactTitle
        ) {

        //add the info to DB through DAO
        boolean result = DAO.addCustomer(custID, compName, contactName, contactTitle);
        //best to check the result
        if (result == false) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "customer add failed");
        }

        ModelAndView mv = new ModelAndView("addResult");
        mv.addObject("CustomerID", custID);
        mv.addObject("CompanyName", compName);
        mv.addObject("ContactName", contactName);
        mv.addObject("ContactTitle", contactTitle);

        return mv;
    }

    @RequestMapping(value = "getAllCustomers")
    public ModelAndView getAllCustomers() {
        ArrayList<Customer> customerList = DAO.getCustomerList();

        //TODO: make error.jsp
        if (customerList == null) {
            return new ModelAndView("error", "errmsg", "Customer list is null");
        }

        return new ModelAndView("customerView","cList",customerList);
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer (
            Model model,
            @RequestParam("CustomerID") String custID) {
        //make it happen with the DB
        boolean result = DAO.deleteCustomer(custID);

        if (result == false) {
            model.addAttribute("errmsg", "Delete failed");
            return "error";
        }
        //adding info without a ModelAndView
        //get the model as a argument above
        //and add to it
        model.addAttribute("custID", custID);
        return "deleted";
    }
}