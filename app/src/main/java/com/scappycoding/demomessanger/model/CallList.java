package com.scappycoding.demomessanger.model;

public class CallList {

    private String userID;
    private String userName;
    private String date;
    private String uriProfile;
    private String callType;


    // Basic Empty Constructor
    public  CallList(){

    }


    // Constructor with all Parameters of CallList Types

    public CallList(String userID, String userName, String date, String uriProfile, String callType) {
        this.userID = userID;
        this.userName = userName;
        this.date = date;
        this.uriProfile = uriProfile;
        this.callType = callType;
    }


    // All Getter and Setter of this Parameters

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

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }
}
