package com.example.model;

public class Pickupmodel {
   private String name;
   private String phone_no;
   private String address;
   private String area;
   private String city;
   private String pincode;
   private String scrapType;
   private String datepicker;
   private String pickuptime;

   

   public Pickupmodel(String name,String phone_no,String address,String area,String city,String pincode,String scrapType,String datepicker,String pickuptime ){
    this.name=name;
    this.phone_no=phone_no;
    this.address=address;
    this.area=area;
    this.city=city;
    this.pincode=pincode;
    this.scrapType=scrapType;
    this.datepicker=datepicker;
    this.pickuptime=pickuptime;
    
   }
     public String getName() {
    return name;
}

   public String getPhone_no() {
    return phone_no;
   }

   public String getAddress() {
    return address;
   }

   public String getArea() {
    return area;
   }

   public String getCity() {
    return city;
   }

   public String getPincode() {
    return pincode;
   }

   public String getScrapType() {
    return scrapType;
   }

   public String getDatepicker() {
    return datepicker;
   }

   public String getPickuptime() {
    return pickuptime;
   }
    

}




