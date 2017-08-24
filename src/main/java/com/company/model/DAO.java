package com.company.model;

import com.company.controller.User;
import com.company.controller.User;
import org.jasypt.util.password.StrongPasswordEncryptor;
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
    public static ArrayList<User> getUserList() {
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

            String readUserCommand = "select userId,fname, lname, email, cellphone, password from users";

            Statement readUsers = mysqlConnection.createStatement();// creates the statement

            ResultSet results = readUsers.executeQuery(readUserCommand);// executes the statement
            // array list of customers
            ArrayList<User> userList = new ArrayList<User>();

            // map from the ResultSet to the ArrayList
            while (results.next()) {
                User temp = new User(results.getString(1),
                        results.getString(2), results.getString(3),
                        results.getString(4), results.getString(5), results.getString(6));
                userList.add(temp);

            }

            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; //null result indicates an issue
        }
    }

    public static boolean addUser(
            String userId,
            String fName,
            String lName,
            String email,
            String Cphone,
            String password
    ) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addUserCommand = "INSERT INTO users " +
                    "(userId, fName, lName, email, cellPhone, password) " +
                    "VALUES ('" +
                    userId + "', '" +
                    fName + "', '" +
                    lName + "', '" +
                    email + "', '" +
                    Cphone + "', '" +

                    password + "')";
            System.out.println("SQL Query " + addUserCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(addUserCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }

    public static boolean deleteUser(String userId) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String deleteUserCommand = "DELETE FROM users " +
                    "WHERE userId = '" +
                    userId + "'";
            System.out.println("SQL Deletion Query " + deleteUserCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(deleteUserCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }

    StrongPasswordEncryptor enc = new StrongPasswordEncryptor();

}
