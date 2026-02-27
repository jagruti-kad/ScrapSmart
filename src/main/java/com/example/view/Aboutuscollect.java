package com.example.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class Aboutuscollect {
    Scene page11Scene;
    Stage p11Stage;

    public void setScene(Scene scene) {
        this.page11Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p11Stage = stage;
    }

    public VBox createScene(Runnable back) {
        // Main content container
        VBox mainContent = new VBox(40);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(40));

        // Spectacular heading with enhanced styling for collectors
        Text headingIcon = new Text("🚛");
        headingIcon.setFont(Font.font(50));
        
        Text heading = new Text("Collector Guide - How It Works");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 38));
        heading.setFill(Color.WHITE);
        heading.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 4, 0, 2, 2);");
        
        Text subtitle = new Text("🌿 Your Complete Guide to Professional Scrap Collection");
        subtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        subtitle.setFill(Color.web("#e8f5e8"));
        subtitle.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 2, 0, 1, 1);");

        VBox headingContent = new VBox(8, headingIcon, heading, subtitle);
        headingContent.setAlignment(Pos.CENTER);
        
        VBox headingBox = new VBox(headingContent);
        headingBox.setAlignment(Pos.CENTER);
        headingBox.setPadding(new Insets(30));
        headingBox.setStyle(
            "-fx-background-color: linear-gradient(to right, #1b5e20, #2e7d32, #388e3c);" +
            "-fx-background-radius: 25;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 15, 0, 0, 8);"
        );
        headingBox.setMaxWidth(850);

        // Enhanced cards without numbering
        VBox card1 = createCollectorCard(
            "✅", "Accept Pickup Requests",
            "View available pickup requests in your area with full scrap details. Accept any request that suits your time and route.",
            "#2e7d32", "#e8f5e8"
        );
        
        VBox card2 = createCollectorCard(
            "☎️", "Confirm with User", 
            "Contact the user to confirm pickup time, location, and any special instructions before arriving.",
            "#388e3c", "#f1f8e9"
        );
        
        VBox card3 = createCollectorCard(
            "⚖️", "Weight and Collect Scrap",
            "Visit the location with tools, weight scrap items on-site, and enter the weight in the app to calculate total value.",
            "#43a047", "#f3e5f5"
        );
        
        VBox card4 = createCollectorCard(
            "💰", "Mark Completed & Get Paid",
            "Complete the pickup in the app. Payment is recorded and added to your account or scheduled for weekly transfer.",
            "#4caf50", "#e8f5e8"
        );

        // Enhanced grid layout with better spacing
        GridPane grid = new GridPane();
        grid.setHgap(35);
        grid.setVgap(35);
        grid.setPadding(new Insets(30));
        grid.setAlignment(Pos.CENTER);
        grid.add(card1, 0, 0);
        grid.add(card2, 1, 0);
        grid.add(card3, 0, 1);
        grid.add(card4, 1, 1);

        // Add content to main container
        mainContent.getChildren().addAll(headingBox, grid);

        // Enhanced ScrollPane with sophisticated styling
        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPrefHeight(700);
        scrollPane.setMaxHeight(800);
        scrollPane.setStyle(
            "-fx-background: transparent;" +
            "-fx-background-color: transparent;" +
            "-fx-border-color: transparent;"
        );
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Spectacular back button for collectors
        Button prvButton1 = new Button("🔙 Back To Dashboard");
        prvButton1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        prvButton1.setPrefHeight(60);
        prvButton1.setPrefWidth(320);
        prvButton1.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #2e7d32, #1b5e20);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);" +
            "-fx-cursor: hand;"
        );
        
        prvButton1.setOnMouseEntered(e -> prvButton1.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 0, 5);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.05;" +
            "-fx-scale-y: 1.05;"
        ));
        
        prvButton1.setOnMouseExited(e -> prvButton1.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #2e7d32, #1b5e20);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.0;" +
            "-fx-scale-y: 1.0;"
        ));

        // Keep exact same functionality
        prvButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });

        // Enhanced button container
        HBox buttonContainer = new HBox(prvButton1);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(30));
        buttonContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-background-radius: 20;"
        );

        // Create sophisticated multi-layer background with darker green theme
        VBox backgroundLayer1 = new VBox();
        backgroundLayer1.setStyle(
            "-fx-background-color: " +
            "linear-gradient(135deg, " +
            "#0d5016 0%, " +
            "#1b5e20 10%, " +
            "#2e7d32 20%, " +
            "#388e3c 30%, " +
            "#43a047 40%, " +
            "#4caf50 50%, " +
            "#66bb6a 60%, " +
            "#81c784 70%, " +
            "#a5d6a7 80%, " +
            "#c8e6c8 90%, " +
            "#e8f5e8 100%);"
        );

        VBox backgroundLayer2 = new VBox();
        backgroundLayer2.setStyle(
            "-fx-background-color: " +
            "radial-gradient(at 20% 30%, rgba(27, 94, 32, 0.4) 0%, transparent 50%), " +
            "radial-gradient(at 80% 70%, rgba(46, 125, 50, 0.3) 0%, transparent 50%), " +
            "radial-gradient(at 40% 10%, rgba(56, 142, 60, 0.25) 0%, transparent 50%), " +
            "radial-gradient(at 10% 80%, rgba(67, 160, 71, 0.35) 0%, transparent 50%), " +
            "radial-gradient(at 90% 20%, rgba(76, 175, 80, 0.3) 0%, transparent 50%);"
        );

        VBox backgroundLayer3 = new VBox();
        backgroundLayer3.setStyle(
            "-fx-background-color: " +
            "repeating-linear-gradient(60deg, " +
            "transparent 0px, " +
            "transparent 35px, " +
            "rgba(255,255,255,0.02) 35px, " +
            "rgba(255,255,255,0.02) 70px), " +
            "repeating-linear-gradient(-60deg, " +
            "transparent 0px, " +
            "transparent 45px, " +
            "rgba(255,255,255,0.015) 45px, " +
            "rgba(255,255,255,0.015) 90px);"
        );

        // Main layout with ScrollPane and button
        VBox mainLayout = new VBox(20, scrollPane, buttonContainer);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(25));
        mainLayout.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.05);" +
            "-fx-background-radius: 25;"
        );

        // Root container with spectacular background
        StackPane backgroundStack = new StackPane();
        backgroundStack.getChildren().addAll(backgroundLayer1, backgroundLayer2, backgroundLayer3);

        StackPane finalRoot = new StackPane();
        finalRoot.getChildren().addAll(backgroundStack, mainLayout);

        VBox container = new VBox(finalRoot);
        container.setStyle(
            "-fx-background-color: " +
            "linear-gradient(135deg, " +
            "#0d5016 0%, " +
            "#1b5e20 6%, " +
            "#2e7d32 12%, " +
            "#388e3c 18%, " +
            "#43a047 24%, " +
            "#4caf50 30%, " +
            "#66bb6a 36%, " +
            "#81c784 42%, " +
            "#a5d6a7 48%, " +
            "#c8e6c8 54%, " +
            "#dcedc8 60%, " +
            "#e8f5e8 66%, " +
            "#f1f8e9 72%, " +
            "#f9fbe7 78%, " +
            "#ffffff 84%, " +
            "#ffffff 100%);"
        );

        return container;
    }

    private VBox createCollectorCard(String icon, String title, String description, String primaryColor, String backgroundColor) {
        // Enhanced icon with larger size and styling
        Text iconText = new Text(icon);
        iconText.setFont(Font.font(65));
        iconText.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 4, 0, 2, 2);");
        
        // Icon container with circular background
        VBox iconContainer = new VBox(iconText);
        iconContainer.setAlignment(Pos.CENTER);
        iconContainer.setPrefSize(100, 100);
        iconContainer.setStyle(
            "-fx-background-color: " + primaryColor + ";" +
            "-fx-background-radius: 50;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8, 0, 0, 4);"
        );
        
        // Enhanced title with better styling
        Text titleText = new Text(title);
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleText.setFill(Color.web("#1a202c"));
        titleText.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 2, 0, 1, 1);");
        
        // Enhanced description with better readability
        Text descText = new Text(description);
        descText.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        descText.setWrappingWidth(320);
        descText.setFill(Color.web("#2d3748"));
        descText.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 1, 0, 0, 1);");

        // Content area with title and description
        VBox contentArea = new VBox(12, titleText, descText);
        contentArea.setAlignment(Pos.TOP_CENTER);
        contentArea.setPadding(new Insets(15, 0, 0, 0));

        // Main card container with collector-specific styling
        VBox card = new VBox(20, iconContainer, contentArea);
        card.setAlignment(Pos.TOP_CENTER);
        card.setPadding(new Insets(30));
        card.setPrefSize(380, 320);
        card.setMaxSize(380, 320);
        card.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #ffffff, " + backgroundColor + ");" +
            "-fx-border-color: linear-gradient(to right, " + primaryColor + ", #66bb6a);" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 20;" +
            "-fx-background-radius: 20;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 12, 0, 0, 6);"
        );

        // Enhanced hover effects with collector theme
        card.setOnMouseEntered(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #f0f8f0, " + backgroundColor + ");" +
                "-fx-border-color: linear-gradient(to right, #1b5e20, #2e7d32);" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-effect: dropshadow(gaussian, rgba(27, 94, 32, 0.3), 18, 0, 0, 10);" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.03;" +
                "-fx-scale-y: 1.03;"
            );
        });
        
        card.setOnMouseExited(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #ffffff, " + backgroundColor + ");" +
                "-fx-border-color: linear-gradient(to right, " + primaryColor + ", #66bb6a);" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 12, 0, 0, 6);" +
                "-fx-scale-x: 1.0;" +
                "-fx-scale-y: 1.0;"
            );
        });

        return card;
    }
}
