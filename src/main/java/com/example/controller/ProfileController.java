package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.model.Authmodel;
import com.google.cloud.firestore.DocumentSnapshot;

public class ProfileController {
       public static void storeProfile(String name, String email,String username,String mobile,String address) throws Exception {
        Map<String, Object> profileData = new HashMap<>();
        profileData.put("name", name);
        profileData.put("email", email);
        profileData.put("userName", username);
        profileData.put("mobile", mobile);
        profileData.put("address", address);

        FirebaseUtil.db.collection("User").document(Authmodel.getEmail()).set(profileData).get();
    }
    public static Map<String, Object> readPlayer() throws Exception {
        DocumentSnapshot document = FirebaseUtil.db.collection("User").document(Authmodel.getEmail()).get().get();
        if (document.exists()) {
            return document.getData();
        } else {
            return null;
        }
    }

}
