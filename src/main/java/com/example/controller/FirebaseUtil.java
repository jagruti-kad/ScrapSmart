package com.example.controller;



import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;

public class FirebaseUtil {

    public static Firestore db;

    // 🔹 Call this once during app startup
    public static void initializeFirebase() throws Exception {
        if (FirebaseApp.getApps().isEmpty()) { // Avoid re-initialization
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/javafx-demo-3e858-firebase-adminsdk-fbsvc-1027498e18.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
        }
        db = FirestoreClient.getFirestore();
    }
}