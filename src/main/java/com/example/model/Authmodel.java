package com.example.model;

public class Authmodel {
    private static String email;

    public Authmodel(String eString){
        this.email=eString;
    }

    public static String getEmail() {
        return email;
    }

}
