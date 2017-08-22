package com.company.controller;


public class User {
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

    private String userId;
    private String fName;
    private String lName;
    private String email;
    private String cPhone;
    private String password;

public User()
{
    userId="";
    fName="";

}
    public User(String uid,String fN, String lN, String eM, String cP, String pw)
    {
        userId=uid;
        fName=fN;
        lName= lN;
        email= eM;
        cPhone=cP;
        password= pw;
    }

}
