package com.company.model;

import com.company.controller.Customer;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by peter on 8/16/17.
 */
public class DAO {
    public static ArrayList<Customer> getCustomerList () {
        // define the data for the connection
        //connection info was pulled out into DBCredentials
        //so that file can be hidden

        try {
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // create the db connection object
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            // create the db statement

            String readCustomersCommand = "select customerid,companyname from customers";

            Statement readCustomers = mysqlConnection.createStatement();// creates the statement

            ResultSet results = readCustomers.executeQuery(readCustomersCommand);// executes the statement
            // array list of customers
            ArrayList<Customer> customerList = new ArrayList<Customer>();

            // map from the ResultSet to the ArrayList
            while(results.next())
            {
                Customer temp = new Customer(results.getString(1),
                        results.getString(2));
                customerList.add(temp);

            }

            return customerList;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null; //null result indicates an issue
        }
    }

    public static boolean addCustomer (
            String custID,
            String compName,
            String contactName,
            String contactTitle
    ) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addCustomerCommand = "INSERT INTO Customers " +
                    "(CustomerID, CompanyName, ContactName, ContactTitle) " +
                    "VALUES ('" +
                    custID + "', '" +
                    compName + "', '" +
                    contactName + "', '" +
                    contactTitle + "')";
            System.out.println("SQL Query " + addCustomerCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(addCustomerCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }

    public static boolean deleteCustomer (String custID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String deleteCustomerCommand = "DELETE FROM Customers " +
                    "WHERE CustomerID = '" +
                    custID + "'";
            System.out.println("SQL Deletion Query " + deleteCustomerCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(deleteCustomerCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }
}
