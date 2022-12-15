package com.scappycoding.demomessanger.model;

public class ChatList {

    private String userID;
    private String userName;
    private String description;
    private String date;
    private String uriProfile;


    // Basic Empty Constructor
    public ChatList() {
    }

    // Custom All in use Parameters Constructor
    public ChatList(String userID, String userName, String description, String date, String uriProfile) {
        this.userID = userID;
        this.userName = userName;
        this.description = description;
        this.date = date;
        this.uriProfile = uriProfile;
    }



    // Getters and Setters of Chat-list Model
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUriProfile() {
        return uriProfile;
    }

    public void setUriProfile(String uriProfile) {
        this.uriProfile = uriProfile;
    }
}
