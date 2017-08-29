package com.company.model;


public class Building {


    private String buildingId;
    private String buildingName;
    private String buildingAddress;
    private String buildingDescription;
    private String buildingImage;
    private String qLineStops;
    private double longitude;
    private double latitude;

    public Building() {

        buildingId = "";
        buildingName = "";
        buildingAddress = "";
        buildingDescription = "";;
        buildingImage = "";
        qLineStops = "";
        longitude = 0;
        latitude = 0;

    }

    public Building(String buildingId, String buildingName, String buildingAddress, String buildingDescription, String buildingImage, String qLineStops, double longitude, double latitude) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingDescription = buildingDescription;
        this.buildingImage = buildingImage;
        this.qLineStops = qLineStops;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }

    public String getBuildingImage() {
        return buildingImage;
    }

    public void setBuildingImage(String buildingImage) {
        this.buildingImage = buildingImage;
    }

    public String getqLineStops() {
        return qLineStops;
    }

    public void setqLineStops(String qLineStops) {
        this.qLineStops = qLineStops;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String toString() {
    String result = "";

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12f%-12f", buildingId,  buildingName,  buildingAddress,  buildingDescription,  buildingImage,  qLineStops, longitude, latitude);

        return result;
    }

}
