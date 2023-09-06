package com.CustomerDetails.service;

public class AuthenticationRequest {
    private String loginId;
    private String password;

    // Constructors, getters, and setters

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

