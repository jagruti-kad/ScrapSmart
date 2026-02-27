package com.example.view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.controller.pickupContoller;

public class Viewform {
    Scene page12Scene;
    Stage p12Stage;

    public void setScene(Scene scene) {
        this.page12Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p12Stage = stage;
    }

    public VBox createScene(Runnable back) throws Exception {
        // Enhanced main container with sophisticated styling
        VBox mainVBox = new VBox(25);
        mainVBox.setPadding(new Insets(30));
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-background-radius: 20;"
        );

        // Spectacular title header
        Text titleIcon = new Text("📋");
        titleIcon.setFont(Font.font(45));
        
        Text titleText = new Text("Pickup Request Management");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        titleText.setFill(Color.WHITE);
        titleText.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 4, 0, 2, 2);");
        
        Text subtitle = new Text("🚛 Review and Accept Customer Pickup Requests");
        subtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        subtitle.setFill(Color.web("#e8f5e8"));
        subtitle.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 2, 0, 1, 1);");

        VBox titleContent = new VBox(8, titleIcon, titleText, subtitle);
        titleContent.setAlignment(Pos.CENTER);
        
        VBox titleContainer = new VBox(titleContent);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(25));
        titleContainer.setStyle(
            "-fx-background-color: linear-gradient(to right, #2e7d32, #388e3c, #43a047);" +
            "-fx-background-radius: 20;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 15, 0, 0, 8);"
        );
        titleContainer.setMaxWidth(700);
        
        mainVBox.getChildren().add(titleContainer);

        // Get pickups with same functionality
        List<Map<String, Object>> pickupList = pickupContoller.formMapList();
        
        if (pickupList.isEmpty()) {
            VBox emptyState = createAttractiveEmptyState();
            mainVBox.getChildren().add(emptyState);
        } else {
            for (Map<String, Object> pickup : pickupList) {
                // Create enhanced text elements with icons
                Text name = createStyledText("👤 Name: " + pickup.get("name"), "#1a202c", FontWeight.BOLD, 16);
                Text phone = createStyledText("📱 Phone: " + pickup.get("phone_no"), "#2d3748", FontWeight.SEMI_BOLD, 15);
                Text area = createStyledText("📍 Area: " + pickup.get("Area"), "#4a5568", FontWeight.NORMAL, 15);
                Text address = createStyledText("🏠 Address: " + pickup.get("Address"), "#4a5568", FontWeight.NORMAL, 15);
                Text city = createStyledText("🏙️ City: " + pickup.get("city"), "#4a5568", FontWeight.NORMAL, 15);
                Text pincode = createStyledText("📮 Pincode: " + pickup.get("Pincode"), "#4a5568", FontWeight.NORMAL, 15);
                Text scrapType = createStyledText("♻️ Scrap Type: " + pickup.get("scrapType"), "#2d3748", FontWeight.SEMI_BOLD, 15);
                Text pickupDate = createStyledText("📅 Pickup Date: " + pickup.get("datepicker"), "#4a5568", FontWeight.NORMAL, 15);
                Text pickupTime = createStyledText("⏰ Pickup Time: " + pickup.get("Pickup_Time"), "#4a5568", FontWeight.NORMAL, 15);
                Text email = createStyledText("📧 Email: " + pickup.get("userEmail"), "#2d3748", FontWeight.SEMI_BOLD, 15);

                // Enhanced message holder
                Text acceptedMsg = new Text();
                acceptedMsg.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                acceptedMsg.setFill(Color.web("#2e7d32"));
                acceptedMsg.setStyle("-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.3), 2, 0, 1, 1);");

                // Spectacular Accept button
                Button submitBtn = new Button("✅ Accept Request");
                submitBtn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                submitBtn.setPrefHeight(45);
                submitBtn.setPrefWidth(180);
                submitBtn.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #4caf50, #2e7d32);" +
                    "-fx-text-fill: white;" +
                    "-fx-background-radius: 25;" +
                    "-fx-border-radius: 25;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 3);" +
                    "-fx-cursor: hand;"
                );
                
                submitBtn.setOnMouseEntered(e -> submitBtn.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #66bb6a, #43a047);" +
                    "-fx-text-fill: white;" +
                    "-fx-background-radius: 25;" +
                    "-fx-border-radius: 25;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 8, 0, 0, 4);" +
                    "-fx-cursor: hand;" +
                    "-fx-scale-x: 1.05;" +
                    "-fx-scale-y: 1.05;"
                ));
                
                submitBtn.setOnMouseExited(e -> submitBtn.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #4caf50, #2e7d32);" +
                    "-fx-text-fill: white;" +
                    "-fx-background-radius: 25;" +
                    "-fx-border-radius: 25;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 3);" +
                    "-fx-cursor: hand;" +
                    "-fx-scale-x: 1.0;" +
                    "-fx-scale-y: 1.0;"
                ));

                // Keep exact same functionality
                submitBtn.setOnAction(event -> {
                    try {
                        String userEmail = (String) pickup.get("userEmail");
                        String docId = (String) pickup.get("docId");
                        String collectorEmail = com.example.model.Authmodel.getEmail();
                        Map<String, Object> updateMap = new HashMap<>();
                        updateMap.put("status", "Accepted");
                        updateMap.put("collectorName", collectorEmail);
                        com.example.controller.FirebaseUtil.db
                                .collection("User")
                                .document(userEmail)
                                .collection("pickup")
                                .document(docId)
                                .update(updateMap)
                                .get();
                        acceptedMsg.setText("✅ Request Accepted Successfully!");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

                // Enhanced button row
                HBox buttonRow = new HBox(15, submitBtn, acceptedMsg);
                buttonRow.setAlignment(Pos.CENTER_LEFT);
                buttonRow.setPadding(new Insets(10, 0, 0, 0));

                // Ultra-attractive card with enhanced styling
                VBox card = new VBox(12);
                card.getChildren().addAll(name, phone, area, address, city, pincode, scrapType, pickupDate, pickupTime, email, buttonRow);
                card.setPadding(new Insets(25));
                card.setStyle(
                    "-fx-background-color: linear-gradient(to bottom right, #ffffff, #f8f9fa);" +
                    "-fx-background-radius: 15;" +
                    "-fx-border-color: linear-gradient(to right, #4caf50, #66bb6a);" +
                    "-fx-border-width: 2;" +
                    "-fx-border-radius: 15;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 10, 0, 0, 5);"
                );
                card.setMaxWidth(650);
                card.setMinWidth(600);

                // Enhanced hover effects for cards
                card.setOnMouseEntered(e -> {
                    card.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #f0f8f0, #e8f5e8);" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-color: linear-gradient(to right, #2e7d32, #388e3c);" +
                        "-fx-border-width: 3;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.3), 15, 0, 0, 8);" +
                        "-fx-scale-x: 1.02;" +
                        "-fx-scale-y: 1.02;"
                    );
                });
                
                card.setOnMouseExited(e -> {
                    card.setStyle(
                        "-fx-background-color: linear-gradient(to bottom right, #ffffff, #f8f9fa);" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-color: linear-gradient(to right, #4caf50, #66bb6a);" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 10, 0, 0, 5);" +
                        "-fx-scale-x: 1.0;" +
                        "-fx-scale-y: 1.0;"
                    );
                });

                mainVBox.getChildren().add(card);
            }
        }

        // Enhanced ScrollPane with sophisticated styling
        ScrollPane scrollPane = new ScrollPane(mainVBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setMaxWidth(1550);
        scrollPane.setMaxHeight(800);
        scrollPane.setStyle(
            "-fx-background-image: url('" + getClass().getResource("/assets/images/blurimg.jpg").toExternalForm() + "');" +
            "-fx-background-size: cover;" +
            "-fx-background-repeat: no-repeat;" +
            "-fx-background-color: transparent;" +
            "-fx-border-color: transparent;"
        );
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Spectacular Back Button
        Button backButton = new Button("🔙 Back to Dashboard");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        backButton.setPrefHeight(55);
        backButton.setPrefWidth(250);
        backButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);" +
            "-fx-cursor: hand;"
        );
        
        backButton.setOnMouseEntered(e -> backButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #66bb6a, #43a047);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 0, 5);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.05;" +
            "-fx-scale-y: 1.05;"
        ));
        
        backButton.setOnMouseExited(e -> backButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.0;" +
            "-fx-scale-y: 1.0;"
        ));

        // Keep exact same functionality
        backButton.setOnAction((ActionEvent e) -> back.run());

        // Enhanced button container
        HBox buttonContainer = new HBox(backButton);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(25));
        buttonContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-background-radius: 20;"
        );

        // Create sophisticated multi-layer background
        VBox backgroundLayer1 = new VBox();
        backgroundLayer1.setStyle(
            "-fx-background-color: " +
            "linear-gradient(135deg, " +
            "#1b5e20 0%, " +
            "#2e7d32 15%, " +
            "#388e3c 30%, " +
            "#43a047 45%, " +
            "#4caf50 60%, " +
            "#66bb6a 75%, " +
            "#81c784 90%, " +
            "#a5d6a7 100%);"
        );

        VBox backgroundLayer2 = new VBox();
        backgroundLayer2.setStyle(
            "-fx-background-color: " +
            "radial-gradient(at 30% 30%, rgba(76, 175, 80, 0.3) 0%, transparent 60%), " +
            "radial-gradient(at 70% 70%, rgba(46, 125, 50, 0.25) 0%, transparent 60%), " +
            "radial-gradient(at 20% 80%, rgba(56, 142, 60, 0.2) 0%, transparent 60%), " +
            "radial-gradient(at 80% 20%, rgba(67, 160, 71, 0.3) 0%, transparent 60%);"
        );

        // Root container with spectacular background
        StackPane backgroundStack = new StackPane();
        backgroundStack.getChildren().addAll(backgroundLayer1, backgroundLayer2);

        VBox rootContainer = new VBox(20, scrollPane, buttonContainer);
        rootContainer.setAlignment(Pos.TOP_CENTER);
        rootContainer.setPadding(new Insets(25));

        StackPane finalRoot = new StackPane();
        finalRoot.getChildren().addAll(backgroundStack, rootContainer);

        VBox container = new VBox(finalRoot);
        container.setStyle(
            "-fx-background-color: " +
            "linear-gradient(135deg, " +
            "#1b5e20 0%, " +
            "#2e7d32 10%, " +
            "#388e3c 20%, " +
            "#43a047 30%, " +
            "#4caf50 40%, " +
            "#66bb6a 50%, " +
            "#81c784 60%, " +
            "#a5d6a7 70%, " +
            "#c8e6c8 80%, " +
            "#dcedc8 90%, " +
            "#e8f5e8 100%);"
        );

        return container;
    }

    private VBox createAttractiveEmptyState() {
        Text emptyIcon = new Text("📋");
        emptyIcon.setFont(Font.font(60));
        
        Text emptyTitle = new Text("No Pickup Requests Available");
        emptyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        emptyTitle.setFill(Color.WHITE);
        emptyTitle.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.7), 3, 0, 2, 2);");
        
        Text emptySubtitle = new Text("Customer pickup requests will appear here when available");
        emptySubtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        emptySubtitle.setFill(Color.web("#e8f5e8"));
        
        VBox emptyContainer = new VBox(20, emptyIcon, emptyTitle, emptySubtitle);
        emptyContainer.setAlignment(Pos.CENTER);
        emptyContainer.setPadding(new Insets(50));
        emptyContainer.setStyle(
            "-fx-background-color: " +
            "linear-gradient(45deg, " +
            "#2e7d32 0%, " +
            "#388e3c 33%, " +
            "#43a047 66%, " +
            "#4caf50 100%);" +
            "-fx-background-radius: 20;" +
            "-fx-effect: " +
            "dropshadow(gaussian, rgba(46, 125, 50, 0.4), 15, 0, 0, 8);"
        );
        
        return emptyContainer;
    }

    private Text createStyledText(String content, String color, FontWeight weight, double size) {
        Text text = new Text(content);
        text.setFont(Font.font("Arial", weight, size));
        text.setFill(Color.web(color));
        text.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 1, 0, 0, 1);");
        return text;
    }
}

