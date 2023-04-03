package com.example.onlinefoodapplicationproject;

import java.io.Serializable;

public class ModelUser implements Serializable {

    String dashlvl="";

    public String getDbID() {
        return dbID;
    }

    public void setDbID(String dbID) {
        this.dbID = dbID;
    }

    String dbID="";

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone="";

    public String getUser_access_token() {
        return user_access_token;
    }

    public void setUser_access_token(String user_access_token) {
        this.user_access_token = user_access_token;
    }
    String user_access_token;
    String userLoginLat="0.0";
    public String getUserLoginLat() {
        return userLoginLat;
    }

    public void setUserLoginLat(String userLoginLat) {
        this.userLoginLat = userLoginLat;
    }

    public String getUserLoginLng() {
        return userLoginLng;
    }

    public void setUserLoginLng(String userLoginLng) {
        this.userLoginLng = userLoginLng;
    }

    public String getUserLoginIP() {
        return userLoginIP;
    }

    public void setUserLoginIP(String userLoginIP) {
        this.userLoginIP = userLoginIP;
    }

    String userLoginLng="0.0";
    String userLoginIP="";
    String fireBaseId = "";
    String fireBaseToken = "";
    String userId = "";
    String org_id = "";
    String fileNumber = "";

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    String designation = "";

    String dept_id = "";
    String username = "";

    String user_role = "";
    String salutation = "";
    String alfanaremail = "";


    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    String userLoginPassword="";

    public String getFireBaseId() {
        return fireBaseId;
    }

    public void setFireBaseId(String fireBaseId) {
        this.fireBaseId = fireBaseId;
    }

    public String getFireBaseToken() {
        return fireBaseToken;
    }

    public void setFireBaseToken(String fireBaseToken) {
        this.fireBaseToken = fireBaseToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getAlfanaremail() {
        return alfanaremail;
    }

    public void setAlfanaremail(String alfanaremail) {
        this.alfanaremail = alfanaremail;
    }

    public String getDashlvl() {
        return dashlvl;
    }

    public void setDashlvl(String dashlvl) {
        this.dashlvl = dashlvl;
    }
}
