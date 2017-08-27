package com.company.model;


public class Building {


    private String buildingId;
    private String buildingName;
    private String buildingAddress;
    private String buildingDescription;
    private String buildingImage;
    private String qLineStops;

    public Building() {

        buildingId = "";
        buildingName = "";
        buildingAddress = "";
        buildingDescription = "";;
        buildingImage = "";
        qLineStops = "";

    }

    public Building(String buildingId, String buildingName, String buildingAddress, String buildingDescription, String buildingImage, String qLineStops) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingDescription = buildingDescription;
        this.buildingImage = buildingImage;
        this.qLineStops = qLineStops;
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

    public String toString() {
    String result = "";

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s", buildingId,  buildingName,  buildingAddress,  buildingDescription,  buildingImage,  qLineStops);

        return result;
    }

}
