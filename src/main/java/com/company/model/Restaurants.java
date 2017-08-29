package com.company.model;


public class Restaurants {

   public Restaurants(){
       restName = "";
       restLoc = "";
       restCuisines = "";
       restAvgCost = "";
       restUrl = "";

    }

    public Restaurants(String rName, String rLoc, String rCuisines, String rAvg, String rUrl){

         restName = rName;
         restLoc = rLoc;
         restCuisines = rCuisines;
         restAvgCost = rAvg;
         restUrl = rUrl;

    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestLoc() {
        return restLoc;
    }

    public void setRestLoc(String restLoc) {
        this.restLoc = restLoc;
    }

    public String getRestCuisines() {
        return restCuisines;
    }

    public void setRestCuisines(String restCuisines) {
        this.restCuisines = restCuisines;
    }

    public String getRestAvgCost() {
        return restAvgCost;
    }

    public void setRestAvgCost(String restAvgCost) {
        this.restAvgCost = restAvgCost;
    }

    public String getRestUrl() {
        return restUrl;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }

    private String restName;
    private String restLoc;
    private String restCuisines;
    private String restAvgCost;
    private String restUrl;
}
