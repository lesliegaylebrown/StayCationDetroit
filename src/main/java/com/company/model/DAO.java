package com.company.model;

import com.company.controller.User;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO {

    public static ArrayList<User> getUserList() {

        try {
//             Load driver JDBC driver allows connection & communication to a mySQL Dbase
            Class.forName("com.mysql.jdbc.Driver");


            // create the db connection object (mysqlconnection)
            Connection mysqlConnection;
//          Assigns the function of establishing a connection with the Dbase
            mysqlConnection = DriverManager.getConnection(
//                    pulls login information from DBCredentials.java (excluded from github with .gitignore)
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            // create the db query statement to list all rows from the users table

            String readUserCommand = "select userId,fname, lname, email, cellphone, password from users";

            // Assigns the function of converting the above query for mysql to read
            Statement readUsers = mysqlConnection.createStatement();

          // executes the statement
            ResultSet results = readUsers.executeQuery(readUserCommand);

            // array list of users
            ArrayList<User> userList = new ArrayList<User>();

            // map from the ResultSet to the ArrayList. Reads from Dbase as long as there is data to be read (.next)
            while (results.next()) {

//                 Gets the String data from each cell in the row, in the table (users table)
                User temp = new User(results.getString(1),
                        results.getString(2), results.getString(3),
                        results.getString(4), results.getString(5), results.getString(6));
//                Creates an object from the data pulled from the Dbase, adds it to the array list
                userList.add(temp);

            }

            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; //null result indicates an issue
        }
    }


    public static ArrayList<Building> getBuildingList() {

        try {
//            Load driver JDBC driver allows connection & communication to a mySQL Dbase
            Class.forName("com.mysql.jdbc.Driver");

// create the db connection object (mysqlconnection)
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            // create the db statement

            String readBuildingCommand = "select buildingId,  buildingName,  buildingAddress,  buildingDescription,  buildingImage,  qLineStops, longitude, latitude from attractions";

            Statement readBuilding = mysqlConnection.createStatement();// creates the statement

            ResultSet results = readBuilding.executeQuery(readBuildingCommand);// executes the statement
            // array list of Buildings
            ArrayList<Building> buildingList = new ArrayList<Building>();

            // map from the ResultSet to the ArrayList
            while (results.next()) {
                Building temp = new Building(results.getString(1),
                        results.getString(2), results.getString(3),
                        results.getString(4), results.getString(5), results.getString(6), results.getDouble(7), results.getDouble(8));
//          loops through results of database query to create
//          new arrayList
                buildingList.add(temp);

            }

            return buildingList;
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
            // array list of users

            if (result == 1)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //null result indicates an issue
        }
        return false;

    }

    public static boolean addAdminUser(
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

            String addUserCommand = "INSERT INTO AdminUsers " +
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
            // array list of users

            if (result == 1)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //null result indicates an issue
        }
        return false;

    }


//    Add building to dbase

    public static boolean AddBuilding(
            String buildingId,
            String buildingName,
            String buildingAddress,
            String buildingDescription,
            String buildingImage,
            String qlineStops,
            double longitude,
            double latitude
    ) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addBuildingCommand = "INSERT INTO attractions " +
                    "(buildingId, buildingName, buildingAddress, buildingDescription, buildingImage, qlineStops, longitude, latitude) " +
                    "VALUES ('" +
                    buildingId + "', '" +
                    buildingName + "', '" +
                    buildingAddress + "', '" +
                    buildingDescription + "', '" +"resources/buildings/"+buildingImage + "', '" +
                    qlineStops + "', '" +
                    longitude + "', '" +
                    latitude + "')";
//            System.out.println("SQL Query " + addBuildingCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(addBuildingCommand);// executes the statement
            // array list of users

            if (result == 1)
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //null result indicates an issue
        }
        return false;

    }


    public static boolean login(
            String userId,
            String password

    ) {


        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String readUserCommand = "select userId, password from users where userId='"
            + userId + "'";

            Statement readUsers = mysqlConnection.createStatement();// creates the statement

            ResultSet results = readUsers.executeQuery(readUserCommand);// executes the statement

            // array list of users
            ArrayList<User> userList = new ArrayList<User>();

            // map from the ResultSet to the ArrayList
            while (results.next()) {

                String dbResPassword = results.getString(6);
                StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
                boolean match = enc.checkPassword(password, dbResPassword);

                if (match) {
                    return true;
                }
            }

            return false;

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return true;
    }



    public static boolean Adminlogin(
            String userId,
            String password

    ) {


        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String readUserCommand = "select userId, password from AdminUsers where userId='"
                    + userId + "'";

            Statement readUsers = mysqlConnection.createStatement();// creates the statement

            ResultSet results = readUsers.executeQuery(readUserCommand);// executes the statement

            // array list of users
            ArrayList<User> userList = new ArrayList<User>();

            // map from the ResultSet to the ArrayList
            while (results.next()) {

                String dbResPassword = results.getString(6);
                StrongPasswordEncryptor enc = new StrongPasswordEncryptor();
                boolean match = enc.checkPassword(password, dbResPassword);

                if (match) {
                    return true;
                }
            }

            return false;

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return true;
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
            // array list of users

            //if (result == 1)
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }
}