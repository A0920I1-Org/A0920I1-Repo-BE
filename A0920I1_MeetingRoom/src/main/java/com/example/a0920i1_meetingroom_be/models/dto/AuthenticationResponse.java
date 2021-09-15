package com.example.a0920i1_meetingroom_be.models.dto;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public AuthenticationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
