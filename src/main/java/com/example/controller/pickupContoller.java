package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Authmodel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class pickupContoller {
     public static void storePickUp(String name,String phone_no,String address,String area,String city,String pincode,String scrap,String datepicker,String pickuptime ) throws Exception {
        Map<String, Object> pickData = new HashMap<>();
        pickData.put("name", name);
        pickData.put("phone_no", phone_no);
        pickData.put("Address", address);
        pickData.put("Area", area);
        pickData.put("city", city);
        pickData.put("Pincode", pincode);
        pickData.put("scrapType", scrap);
        pickData.put("datepicker", datepicker);
        pickData.put("Pickup_Time", pickuptime);
    
        System.out.println("scrapType = " + scrap);
        FirebaseUtil.db.collection("User").document(Authmodel.getEmail()).collection("pickup").document().set(pickData).get();
    }
   public static List<Map<String, Object>> pickMapList() throws Exception {
    List<Map<String, Object>> pickupList = new ArrayList<>();
    ApiFuture<QuerySnapshot> future = FirebaseUtil.db
        .collection("User")
        .document(Authmodel.getEmail())
        .collection("pickup")
        .get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (QueryDocumentSnapshot doc : documents) {
        pickupList.add(doc.getData());
    }
    return pickupList;
}

  public static List<Map<String, Object>> formMapList() throws Exception {
    List<Map<String, Object>> pickupList = new ArrayList<>();

    // Step 1: Fetch all users from "User" collection
    ApiFuture<QuerySnapshot> userFuture = FirebaseUtil.db.collection("User").get();
    List<QueryDocumentSnapshot> userDocs = userFuture.get().getDocuments();

    // Step 2: Loop over each user document
    for (QueryDocumentSnapshot userDoc : userDocs) {
        String userEmail = userDoc.getId(); // User document ID (email)

        // Step 3: Fetch all pickups under this user
        ApiFuture<QuerySnapshot> pickupFuture = FirebaseUtil.db
                .collection("User")
                .document(userEmail)
                .collection("pickup")
                .get();

        List<QueryDocumentSnapshot> pickupDocs = pickupFuture.get().getDocuments();

        // Step 4: Loop over each pickup and add to the list
        for (QueryDocumentSnapshot pickupDoc : pickupDocs) {
            Map<String, Object> data = new HashMap<>(pickupDoc.getData());
            data.put("docId", pickupDoc.getId());         // Pickup document ID
            data.put("userEmail", userEmail);             // User email (document ID)
            pickupList.add(data);
        }
    }

    return pickupList;
}

}
