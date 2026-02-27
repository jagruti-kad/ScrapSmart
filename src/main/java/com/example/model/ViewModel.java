package com.example.model;

public class ViewModel {
    
   private String name;
    private String email;
    private String userName;
    private String mobile;
    private String Address;

   public ViewModel(String name,String email,String username,String mobile,String Address ){
    this.name=name;
    this.email=email;
    this.userName=username;
    this.mobile=mobile;
    this.Address=Address;

    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getUserName() {
        return userName;
    }
    public String getMobile() {
        return mobile;
    }
    public String getAddress() {
        return Address;
    }

   
}
