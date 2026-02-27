package com.example.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthController {
    public static boolean signUp(String email,String password){
    try{
        URL url=new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAAT6yIB2R5BUxMyzAWaoqLpTkCGYeMP-c");

    
    HttpURLConnection con=(HttpURLConnection)url.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json");
    con.setDoOutput(true);
    String payload=String.format("{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}",email,password);
    OutputStream os=null;
    os=con.getOutputStream();
    os.write(payload.getBytes());
    int responseCode=con.getResponseCode();
    if(responseCode==200){
        return true;
    }else{
        BufferedReader br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
        
         String temp =null;
         while ((temp=br.readLine())!= null) {
           System.out.println(temp);;
         }
    }
    return false;

}catch(Exception ex){
   ex.printStackTrace();
   return false;
}

}

  public static boolean signIn(String email,String password){
    try{
        URL url=new URL("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAAT6yIB2R5BUxMyzAWaoqLpTkCGYeMP-c");

    
    HttpURLConnection con=(HttpURLConnection)url.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json");
    con.setDoOutput(true);
    String payload=String.format("{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}",email,password);
    OutputStream os=null;
    os=con.getOutputStream();
    os.write(payload.getBytes());
    int responseCode=con.getResponseCode();
    if(responseCode==200){
        return true;
    }else{
        BufferedReader br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
        
         String temp =null;
         while ((temp=br.readLine())!= null) {
           System.out.println(temp);;
         }
    }
    return false;

}catch(Exception ex){
   ex.printStackTrace();
   return false;
}

}
}
