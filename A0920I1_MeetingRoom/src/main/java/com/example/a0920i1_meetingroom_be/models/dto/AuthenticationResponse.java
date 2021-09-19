package com.example.a0920i1_meetingroom_be.models.dto;


//TuHC
public class AuthenticationResponse {
    private String token;
    private String status;

    public AuthenticationResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
