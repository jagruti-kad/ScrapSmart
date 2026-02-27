package com.example.view;

import java.util.List;
import java.util.Map;
import com.example.controller.pickupContoller;
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

public class hisUser {
    Scene page13Scene;
    Stage p13Stage;

    public void setScene(Scene scene) {
        this.page13Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p13Stage = stage;
    }

    public VBox createScene(Runnable back) throws Exception {
        // Ultra-attractive main container with sophisticated green gradient
        VBox cardContainer = new VBox(30);
        cardContainer.setPadding(new Insets(30));
        cardContainer.setAlignment(Pos.TOP_CENTER);
        cardContainer.setStyle(
            "-fx-background-color: " +
            "radial-gradient(center 50% 20%, radius 80%, " +
            "rgba(232, 245, 233, 0.9) 0%, " +
            "rgba(220, 237, 200, 0.8) 40%, " +
            "rgba(200, 230, 201, 0.7) 100%);"
        );

        // Spectacular title header with multiple green effects
        Text titleIcon = new Text("🌿");
        titleIcon.setFont(Font.font(40));
        
        Text titleText = new Text("Pickup History Dashboard");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        titleText.setFill(Color.WHITE);
        titleText.setStyle(
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 4, 0, 2, 2);"
        );
        
        Text subtitle = new Text("🚛 Track Your Completed Green Pickups");
        subtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        subtitle.setFill(Color.web("#e8f5e8"));
        subtitle.setStyle(
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 2, 0, 1, 1);"
        );

        VBox titleContent = new VBox(5, titleIcon, titleText, subtitle);
        titleContent.setAlignment(Pos.CENTER);
        
        VBox titleContainer = new VBox(titleContent);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(25));
        titleContainer.setStyle(
    "-fx-background-color: #2e7d32;" +
    "-fx-background-radius: 20;" +
    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 15, 0, 0, 8);"
);
        
        cardContainer.getChildren().add(titleContainer);

        // Get pickups with same functionality
        List<Map<String, Object>> pickupList = pickupContoller.pickMapList();
        
        if (pickupList.isEmpty()) {
            VBox emptyState = createSpectacularGreenEmptyState();
            cardContainer.getChildren().add(emptyState);
        } else {
            for (Map<String, Object> pickup : pickupList) {
                if (!"Accepted".equals(pickup.get("status"))) continue;
                VBox card = createUltraAttractiveGreenCard(pickup);
                cardContainer.getChildren().add(card);
            }
        }

        // Ultra-enhanced scrollpane
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

        // Spectacular green button
        Button backBtn = createSpectacularGreenButton();
        backBtn.setOnAction(e -> back.run());

        // Enhanced button container
        HBox buttonContainer = new HBox(backBtn);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(30, 0, 20, 0));
        buttonContainer.setStyle(
            "-fx-background-color: rgba(255,255,255,0.1);" +
            "-fx-background-radius: 20;"
        );

        // Create sophisticated multi-layer green background
        VBox backgroundLayer1 = new VBox();
        backgroundLayer1.setStyle(
            "-fx-background-color: " +
            "linear-gradient(135deg, " +
            "#1b5e20 0%, " +
            "#2e7d32 12%, " +
            "#388e3c 24%, " +
            "#43a047 36%, " +
            "#4caf50 48%, " +
            "#66bb6a 60%, " +
            "#81c784 72%, " +
            "#a5d6a7 84%, " +
            "#c8e6c8 96%, " +
            "#e8f5e8 100%);"
        );

        VBox backgroundLayer2 = new VBox();
        backgroundLayer2.setStyle(
            "-fx-background-color: " +
            "radial-gradient(at 30% 30%, rgba(76, 175, 80, 0.4) 0%, transparent 60%), " +
            "radial-gradient(at 70% 70%, rgba(46, 125, 50, 0.3) 0%, transparent 60%), " +
            "radial-gradient(at 20% 80%, rgba(56, 142, 60, 0.25) 0%, transparent 60%), " +
            "radial-gradient(at 80% 20%, rgba(67, 160, 71, 0.35) 0%, transparent 60%), " +
            "radial-gradient(at 50% 10%, rgba(102, 187, 106, 0.3) 0%, transparent 60%), " +
            "radial-gradient(at 10% 50%, rgba(129, 199, 132, 0.25) 0%, transparent 60%);"
        );

        VBox backgroundLayer3 = new VBox();
        backgroundLayer3.setStyle(
            "-fx-background-color: " +
            "repeating-linear-gradient(45deg, " +
            "transparent 0px, " +
            "transparent 30px, " +
            "rgba(255,255,255,0.03) 30px, " +
            "rgba(255,255,255,0.03) 60px), " +
            "repeating-linear-gradient(-45deg, " +
            "transparent 0px, " +
            "transparent 40px, " +
            "rgba(255,255,255,0.02) 40px, " +
            "rgba(255,255,255,0.02) 80px);"
        );

        // Green-themed decorative elements
        VBox decorativeElements = new VBox();
        decorativeElements.setStyle(
            "-fx-background-color: " +
            "radial-gradient(at 15% 25%, rgba(139, 195, 74, 0.2) 0%, transparent 40%), " +
            "radial-gradient(at 85% 75%, rgba(124, 179, 66, 0.15) 0%, transparent 40%), " +
            "radial-gradient(at 45% 85%, rgba(104, 159, 56, 0.1) 0%, transparent 40%), " +
            "radial-gradient(at 75% 15%, rgba(85, 139, 47, 0.12) 0%, transparent 40%), " +
            "radial-gradient(at 25% 65%, rgba(51, 105, 30, 0.08) 0%, transparent 40%);"
        );

        // Root container with spectacular green background
        StackPane backgroundStack = new StackPane();
        backgroundStack.getChildren().addAll(backgroundLayer1, backgroundLayer2, backgroundLayer3, decorativeElements);

        VBox root = new VBox(scrollPane, buttonContainer);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));

        StackPane finalRoot = new StackPane();
        finalRoot.getChildren().addAll(backgroundStack, root);

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

    private VBox createUltraAttractiveGreenCard(Map<String, Object> pickup) {
    // Enhanced text with icons and better styling - keeping original fields plus additional info
    Text name = createSpectacularGreenText("👤 Name: " + pickup.get("name"), "#1a202c", FontWeight.BOLD, 18);
    Text scrapType = createSpectacularGreenText("♻️ Scrap Type: " + pickup.get("scrapType"), "#2d3748", FontWeight.SEMI_BOLD, 16);
    Text pickupDate = createSpectacularGreenText("📅 Pickup Date: " + pickup.get("datepicker"), "#4a5568", FontWeight.NORMAL, 15);
    Text collectorName = createSpectacularGreenText("🚛 Collector: " + pickup.get("collectorName"), "#4a5568", FontWeight.NORMAL, 15);
    //Text pickupTime = new Text("Pickup Time: " + pickup.get("Pickup_Time"));
    // Additional information from the pickup data
    // Text phone = createSpectacularGreenText("📱 Phone: " + pickup.get("phone_no"), "#2d3748", FontWeight.NORMAL, 15);
    // Text address = createSpectacularGreenText("🏠 Address: " + pickup.get("address"), "#2d3748", FontWeight.NORMAL, 15);
    // Text area = createSpectacularGreenText("📍 Area: " + pickup.get("area"), "#4a5568", FontWeight.NORMAL, 15);
    // Text city = createSpectacularGreenText("🏙️ City: " + pickup.get("city"), "#4a5568", FontWeight.NORMAL, 15);
    // Text pincode = createSpectacularGreenText("📮 Pincode: " + pickup.get("pincode"), "#4a5568", FontWeight.NORMAL, 15);
     Text pickupTime = createSpectacularGreenText("⏰ Pickup Time: " + pickup.get("Pickup_Time"), "#4a5568", FontWeight.NORMAL, 15);
    
    // Ultra-enhanced green status
    Text status = createSpectacularGreenText("✅ Status: " + pickup.get("status"), "#2e7d32", FontWeight.BOLD, 16);
    
    // Card with clean white background and green border
    VBox card = new VBox(12);
    card.getChildren().addAll(name,scrapType, pickupDate,pickupTime ,collectorName, status);
    card.setPadding(new Insets(25));
    card.setStyle(
        "-fx-background-color: #ffffff;" +
        "-fx-border-color: #4caf50;" +
        "-fx-border-width: 2;" +
        "-fx-border-radius: 15;" +
        "-fx-background-radius: 15;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 8, 0, 0, 4);"
    );
    card.setMaxWidth(650);
    card.setMinWidth(550);

    // Enhanced hover effects
    card.setOnMouseEntered(e -> {
        card.setStyle(
            "-fx-background-color: #f1f8e9;" +
            "-fx-border-color: #2e7d32;" +
            "-fx-border-width: 3;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.2), 12, 0, 0, 6);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.02;" +
            "-fx-scale-y: 1.02;"
        );
    });
    
    card.setOnMouseExited(e -> {
        card.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #4caf50;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 8, 0, 0, 4);" +
            "-fx-scale-x: 1.0;" +
            "-fx-scale-y: 1.0;"
        );
    });

    return card;
}

private Text createCardText(String content, String color, FontWeight weight, double size) {
    Text text = new Text(content);
    text.setFont(Font.font("Arial", weight, size));
    text.setFill(Color.web(color));
    text.setWrappingWidth(500);
    return text;
}

    private VBox createSpectacularGreenEmptyState() {
        Text emptyIcon = new Text("🌱");
        emptyIcon.setFont(Font.font(60));
        
        Text emptyTitle = new Text("No Green Pickup History Found");
        emptyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        emptyTitle.setFill(Color.WHITE);
        emptyTitle.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.7), 3, 0, 2, 2);");
        
        Text emptySubtitle = new Text("Your eco-friendly completed pickups will appear here");
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
            "dropshadow(gaussian, rgba(46, 125, 50, 0.4), 15, 0, 0, 8), " +
            "innershadow(gaussian, rgba(255,255,255,0.2), 5, 0, 0, 2);"
        );
        
        return emptyContainer;
    }

    private Button createSpectacularGreenButton() {
    Button button = new Button("🏠 Back to Dashboard");
    button.setFont(Font.font("Arial", FontWeight.BOLD, 18));
    button.setPrefHeight(55);
    button.setPrefWidth(250);
    button.setStyle(
        "-fx-background-color: #2e7d32;" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 30;" +
        "-fx-border-radius: 30;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);" +
        "-fx-cursor: hand;"
    );
    
    button.setOnMouseEntered(e -> button.setStyle(
        "-fx-background-color: #1b5e20;" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 30;" +
        "-fx-border-radius: 30;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 0, 5);" +
        "-fx-cursor: hand;" +
        "-fx-scale-x: 1.05;" +
        "-fx-scale-y: 1.05;"
    ));
    
    button.setOnMouseExited(e -> button.setStyle(
        "-fx-background-color: #2e7d32;" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 30;" +
        "-fx-border-radius: 30;" +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);" +
        "-fx-cursor: hand;" +
        "-fx-scale-x: 1.0;" +
        "-fx-scale-y: 1.0;"
    ));

    return button;
}

    private Text createSpectacularGreenText(String content, String color, FontWeight weight, double size) {
        Text text = new Text(content);
        text.setFont(Font.font("Arial", weight, size));
        text.setFill(Color.web(color));
        text.setStyle(
            "-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.2), 2, 0, 1, 1);"
        );
        return text;
    }
}
