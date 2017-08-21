package com.company.controller;

/**
 * Created by kamel on 8/14/2017.
 */
public class Customer {
    private String customerID;
    private String companyName;

public Customer()
{
    customerID="";
    companyName="";

}
    public Customer(String cid,String cname)
    {
        customerID=cid;
        companyName=cname;
    }
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
