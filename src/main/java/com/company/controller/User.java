package com.company.controller;


public class User {


    private String userId;
    private String fName;
    private String lName;
    private String email;
    private String cPhone;
    private String password;

    public User() {
        userId = "";
        fName = "";
        lName = "";
        email = "";
        cPhone = "";
        password = "";

    }

    public User(String userId, String fName, String lName, String email, String cPhone, String password) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.cPhone = cPhone;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {

        String result = "";

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s", userId, fName, lName, email, cPhone, password);
        return result;
    }

}
