package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Authmodel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class FeedController {
    

    public static void storeFeed(String User, String Rate, String Comment) throws Exception {
    Map<String, Object> feedData = new HashMap<>();
    feedData.put("User", User);
    feedData.put("Rate", Rate);
    feedData.put("Comment", Comment);
    feedData.put("userName", Authmodel.getEmail()); 
    feedData.put("status", "Completed"); // 

    FirebaseUtil.db
        .collection("User")
        .document(Authmodel.getEmail())
        .collection("FeedBack")
        .document()
        .set(feedData)
        .get();
}

   public static List<Map<String, Object>> feedMapList() throws Exception {
    List<Map<String, Object>> feedList = new ArrayList<>();
    ApiFuture<QuerySnapshot> future = FirebaseUtil.db
        .collection("User")
        .document(Authmodel.getEmail())
        .collection("FeedBack")
        .get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (QueryDocumentSnapshot doc : documents) {
        feedList.add(doc.getData());
    }
    return feedList;
}

  public static List<Map<String, Object>> getAllFeedbacks() throws Exception {
    List<Map<String, Object>> allFeedbacks = new ArrayList<>();

    // Step 1: Get all user documents
    ApiFuture<QuerySnapshot> userFuture = FirebaseUtil.db
            .collection("User")
            .get();
    List<QueryDocumentSnapshot> users = userFuture.get().getDocuments();

    // Step 2: Loop through each user and fetch their FeedBack subcollection
    for (QueryDocumentSnapshot userDoc : users) {
        String userId = userDoc.getId(); // user email

        // Step 3: Get FeedBack subcollection for this user
        ApiFuture<QuerySnapshot> feedbackFuture = FirebaseUtil.db
                .collection("User")
                .document(userId)
                .collection("FeedBack")
                .get();
        List<QueryDocumentSnapshot> feedbackDocs = feedbackFuture.get().getDocuments();

        // Step 4: Add each feedback to the list
        for (QueryDocumentSnapshot feedbackDoc : feedbackDocs) {
            Map<String, Object> feedbackData = feedbackDoc.getData();
            feedbackData.put("userEmail", userId); // Optional: include user id
            allFeedbacks.add(feedbackData);
        }
    }

    return allFeedbacks;
}

}



