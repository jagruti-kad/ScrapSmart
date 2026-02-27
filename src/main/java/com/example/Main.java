package com.example;
import com.example.controller.FirebaseUtil;
import com.example.view.Landing;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) throws Exception{
        FirebaseUtil.initializeFirebase();
        System.out.println("Hello world!");
    
      Application.launch(Landing.class,args);
    
    }
}