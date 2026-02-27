package com.example.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.controller.FeedController;
import com.example.model.Authmodel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class hisCollector {
    Scene page15Scene;
    Stage p15Stage;

    public void setScene(Scene scene) {
        this.page15Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p15Stage = stage;
    }

    public VBox createScene(Runnable back) throws Exception {
        // Main container with attractive green gradient background
        VBox cardContainer = new VBox(25);
        cardContainer.setPadding(new Insets(25));
        cardContainer.setAlignment(Pos.TOP_CENTER);
        cardContainer.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #e8f5e8, #d4f1d4, #c8e6c8);" // Beautiful green gradient
        );

        // Enhanced content wrapper with subtle styling
        VBox contentWrapper = new VBox(20);
        contentWrapper.setPadding(new Insets(20));
        contentWrapper.setAlignment(Pos.TOP_CENTER);
        contentWrapper.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15);" +
            "-fx-background-radius: 20;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 3);"
        );

        // Attractive title header with enhanced styling
        Text titleText = new Text("📋 Feedback History");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        titleText.setFill(Color.WHITE);
        titleText.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.7), 3, 0, 2, 2);");
        
        VBox titleContainer = new VBox(titleText);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(20));
        titleContainer.setStyle(
            "-fx-background-color: linear-gradient(to right, #2e7d32, #388e3c, #43a047);" + // Green gradient
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 12, 0, 0, 4);"
        );

        contentWrapper.getChildren().add(titleContainer);

        // Get feedbacks
        List<Map<String, Object>> feedbacks = FeedController.getAllFeedbacks();
        
        if (feedbacks.isEmpty()) {
            VBox emptyState = createAttractiveEmptyState();
            contentWrapper.getChildren().add(emptyState);
        } else {
            for (Map<String, Object> feedback : feedbacks) {
                System.out.println("From: " + feedback.get("userEmail"));
                System.out.println("User: " + feedback.get("User"));
                System.out.println("Rate: " + feedback.get("Rate"));
                System.out.println("Comment: " + feedback.get("Comment"));
                System.out.println("Status: " + feedback.get("status"));
                System.out.println("------------");

                VBox card = createAttractiveFeedbackCard(feedback);
                contentWrapper.getChildren().add(card);
            }
        }

        cardContainer.getChildren().add(contentWrapper);

        // Enhanced scrollpane
        ScrollPane scrollPane = new ScrollPane(cardContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle(
            "-fx-background: transparent;" +
            "-fx-background-color: transparent;" +
            "-fx-border-color: transparent;"
        );
        scrollPane.setPrefHeight(650);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Attractive green button
        Button button = createAttractiveButton();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });

        // Button container with enhanced styling
        HBox buttonContainer = new HBox(button);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(25));
        buttonContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-background-radius: 15;"
        );

        // Root container with beautiful gradient background
        VBox vb = new VBox(scrollPane, buttonContainer);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        vb.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #e8f5e8, #d4f1d4, #c8e6c8);" // Matching gradient
        );

        return vb;
    }

    private VBox createAttractiveFeedbackCard(Map<String, Object> feedback) {
        // Enhanced text styling
        Text user = createStyledText("📧 From: " + feedback.get("userEmail"), "#1a365d", FontWeight.BOLD, 15);
        Text name = createStyledText("👤 Username: " + feedback.get("User"), "#2d3748", FontWeight.SEMI_BOLD, 14);
        
        // Enhanced rating with better styling
        String ratingValue = String.valueOf(feedback.get("Rate"));
        Text rate = createStyledText("⭐ Rate: " + ratingValue + "/5 " + generateStars(ratingValue), "#1b5e20", FontWeight.BOLD, 14);
        
        Text commentText = createStyledText("💬 Comment: " + feedback.get("Comment"), "#37474f", FontWeight.NORMAL, 13);
        
        // Enhanced status with better colors
        String statusValue = String.valueOf(feedback.get("status"));
        Text status = createStyledText("📊 Status: " + statusValue, getEnhancedStatusColor(statusValue), FontWeight.BOLD, 14);

        // Beautiful card with enhanced styling
        VBox card = new VBox(12);
        card.getChildren().addAll(user, name, rate, commentText, status);
        card.setPadding(new Insets(20));
        card.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #ffffff, #f8f9fa);" +
            "-fx-background-radius: 12;" +
            "-fx-border-color: linear-gradient(to right, #4caf50, #66bb6a);" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 12;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 8, 0, 0, 4);"
        );
        card.setMaxWidth(550);
        card.setMinWidth(450);

        // Enhanced hover effects
        card.setOnMouseEntered(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #f0f8f0, #e8f5e8);" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: linear-gradient(to right, #2e7d32, #388e3c);" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 12;" +
                "-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.3), 12, 0, 0, 6);" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.02;" +
                "-fx-scale-y: 1.02;"
            );
        });
        
        card.setOnMouseExited(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #ffffff, #f8f9fa);" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: linear-gradient(to right, #4caf50, #66bb6a);" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 12;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 8, 0, 0, 4);" +
                "-fx-scale-x: 1.0;" +
                "-fx-scale-y: 1.0;"
            );
        });

        return card;
    }

    private VBox createAttractiveEmptyState() {
        Text emptyIcon = new Text("📝");
        emptyIcon.setFont(Font.font(48));
        
        Text emptyTitle = new Text("No Feedback Available");
        emptyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        emptyTitle.setFill(Color.WHITE);
        emptyTitle.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 2, 0, 1, 1);");
        
        Text emptySubtitle = new Text("Customer feedback will appear here when available");
        emptySubtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        emptySubtitle.setFill(Color.web("#e8f5e8"));
        
        VBox emptyContainer = new VBox(15, emptyIcon, emptyTitle, emptySubtitle);
        emptyContainer.setAlignment(Pos.CENTER);
        emptyContainer.setPadding(new Insets(40));
        emptyContainer.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #2e7d32, #388e3c);" +
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 4);"
        );
        
        return emptyContainer;
    }

    private Button createAttractiveButton() {
        Button button = new Button("🔙 Back");
        button.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32);" +
            "-fx-text-fill: white;" +
            "-fx-padding: 12 25 12 25;" +
            "-fx-border-radius: 25;" +
            "-fx-background-radius: 25;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 3);" +
            "-fx-cursor: hand;"
        );
        
        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #66bb6a, #43a047);" +
            "-fx-text-fill: white;" +
            "-fx-padding: 12 25 12 25;" +
            "-fx-border-radius: 25;" +
            "-fx-background-radius: 25;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 8, 0, 0, 4);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.05;" +
            "-fx-scale-y: 1.05;"
        ));
        
        button.setOnMouseExited(e -> button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32);" +
            "-fx-text-fill: white;" +
            "-fx-padding: 12 25 12 25;" +
            "-fx-border-radius: 25;" +
            "-fx-background-radius: 25;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 3);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.0;" +
            "-fx-scale-y: 1.0;"
        ));

        return button;
    }

    private Text createStyledText(String content, String color, FontWeight weight, double size) {
        Text text = new Text(content);
        text.setFont(Font.font("Arial", weight, size));
        text.setFill(Color.web(color));
        text.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 1, 0, 0, 1);");
        return text;
    }

    private String generateStars(String ratingValue) {
        try {
            int rating = Integer.parseInt(ratingValue);
            StringBuilder stars = new StringBuilder();
            for (int i = 1; i <= 5; i++) {
                if (i <= rating) {
                    stars.append("🌟"); // Larger, more prominent star
                } else {
                    stars.append("⭐"); // Smaller unfilled star
                }
            }
            return stars.toString();
        } catch (NumberFormatException e) {
            return "⭐⭐⭐⭐⭐";
        }
    }

    private String getEnhancedStatusColor(String status) {
        if (status == null) return "#37474f";
        
        switch (status.toLowerCase()) {
            case "approved":
            case "active":
            case "completed":
                return "#1b5e20"; // Rich green
            case "pending":
            case "review":
                return "#e65100"; // Rich orange
            case "rejected":
            case "cancelled":
                return "#b71c1c"; // Rich red
            default:
                return "#37474f"; // Rich gray
        }
    }
}
