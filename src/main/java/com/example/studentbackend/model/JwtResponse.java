package com.example.studentbackend.model;

import com.example.studentbackend.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    @JsonView(View.Student.class)
    private final String jwttoken;

    @JsonView(View.Student.class)
    private String role;

    public JwtResponse(String jwttoken, String role) {
        this.jwttoken = jwttoken;
        this.role=role;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
