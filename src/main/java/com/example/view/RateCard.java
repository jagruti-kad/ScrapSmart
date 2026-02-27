package com.example.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RateCard {
    Scene page9Scene;
    Stage p9Stage;

    public void setScene(Scene scene) {
        this.page9Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p9Stage = stage;
    }

    public VBox createScene(Runnable back) {
        // Main content container with green theme
        VBox mainContent = new VBox(30);
        mainContent.setPadding(new Insets(35));
        mainContent.setAlignment(Pos.TOP_CENTER);

        // Green themed title
        Label title = new Label("🌿 Premium Rate Card");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        title.setTextFill(Color.WHITE);
        title.setStyle(
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 8, 0, 4, 4);" +
            "-fx-padding: 25 40 25 40;" +
            "-fx-background-color: #2e7d32;" +  // Green background
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;"
        );

        // Green card container
        VBox card = new VBox(0);
        card.setAlignment(Pos.TOP_CENTER);
        card.setMaxWidth(800);
        card.setMinWidth(800);
        card.setStyle(
            "-fx-background-color: #e8f5e8;" +  // Light green background
            "-fx-background-radius: 15;" +
            "-fx-border-radius: 15;" +
            "-fx-border-color: #4caf50;" +  // Green border
            "-fx-border-width: 3;" +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.4), 20, 0, 0, 10);"
        );

        // Green table header
        HBox header = new HBox();
        header.setPadding(new Insets(25));
        header.setAlignment(Pos.CENTER);
        header.setPrefWidth(800);
        header.setMaxWidth(800);
        header.setStyle(
            "-fx-background-color: #2e7d32;" +  // Dark green background
            "-fx-background-radius: 15 15 0 0;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 4);"
        );

        // Header labels
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        
        Label materialHeader = new Label("🏷️ Material Type");
        materialHeader.setTextFill(Color.WHITE);  // White text on green
        materialHeader.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        materialHeader.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.7), 3, 0, 2, 2);");
        materialHeader.setPrefWidth(350);
        materialHeader.setAlignment(Pos.CENTER_LEFT);

        Region centerSpacer = new Region();
        centerSpacer.setPrefWidth(100);

        Label priceHeader = new Label("💰 Price (per kg)");
        priceHeader.setTextFill(Color.WHITE);  // White text on green
        priceHeader.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        priceHeader.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.7), 3, 0, 2, 2);");
        priceHeader.setPrefWidth(350);
        priceHeader.setAlignment(Pos.CENTER);

        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        header.getChildren().addAll(leftSpacer, materialHeader, centerSpacer, priceHeader, rightSpacer);

        // Green data presentation
        VBox tableContainer = new VBox(0);
        tableContainer.setAlignment(Pos.CENTER);
        tableContainer.setPrefWidth(800);
        tableContainer.setMaxWidth(800);

        String[][] data = {
            {"Books", "₹6.50"},
            {"Magazines", "₹6.50"},
            {"White Papers", "₹7.25"},
            {"Iron", "₹10.75"},
            {"Copper", "₹100.00"},
            {"Steel", "₹26.50"},
            {"Plastic", "₹10.25"},
            {"E-Waste", "₹35.05"},
            {"Tin Cane", "₹17.25"}
        };

        for (int i = 0; i < data.length; i++) {
            HBox row = createGreenStyledRow(data[i][0], data[i][1], i % 2 == 0, i == data.length - 1);
            tableContainer.getChildren().add(row);
        }

        // Green themed back button
        Button prvButton1 = new Button("🔙 Back to Dashboard");
        prvButton1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        prvButton1.setPrefHeight(60);
        prvButton1.setPrefWidth(300);
        prvButton1.setStyle(
            "-fx-background-color: #2e7d32;" +  // Green button
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.6), 12, 0, 0, 6);" +
            "-fx-cursor: hand;"
        );

        prvButton1.setOnMouseEntered(e -> prvButton1.setStyle(
            "-fx-background-color: #1b5e20;" +  // Darker green on hover
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(27, 94, 32, 0.8), 18, 0, 0, 10);" +
            "-fx-cursor: hand;" +
            "-fx-scale-x: 1.08;" +
            "-fx-scale-y: 1.08;"
        ));

        prvButton1.setOnMouseExited(e -> prvButton1.setStyle(
            "-fx-background-color: #2e7d32;" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-effect: dropshadow(gaussian, rgba(46, 125, 50, 0.6), 12, 0, 0, 6);" +
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

        // Green button container
        HBox buttonContainer = new HBox(prvButton1);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(35));
        buttonContainer.setStyle(
            "-fx-background-color: #c8e6c8;" +  // Light green background
            "-fx-background-radius: 0 0 15 15;"
        );

        // Assemble the green card
        card.getChildren().addAll(header, tableContainer, buttonContainer);

        // Add to main content
        mainContent.getChildren().addAll(title, card);

        // Green scrollpane
        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle(
            "-fx-background: transparent;" +
            "-fx-background-color: transparent;" +
            "-fx-border-color: transparent;"
        );
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Root container with green background
        VBox root = new VBox(scrollPane);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle(
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

        return root;
    }

    private HBox createGreenStyledRow(String material, String price, boolean isEven, boolean isLast) {
        HBox row = new HBox();
        row.setPadding(new Insets(22));
        row.setAlignment(Pos.CENTER);
        row.setPrefWidth(800);
        row.setMaxWidth(800);

        // Green alternating row colors
        String backgroundColor = isEven ? "#ffffff" : "#f1f8e9";  // White and light green
        String borderRadius = isLast ? "0 0 15 15" : "0";

        row.setStyle(
            "-fx-background-color: " + backgroundColor + ";" +
            "-fx-background-radius: " + borderRadius + ";" +
            "-fx-border-color: rgba(76, 175, 80, 0.3);" +  // Green border
            "-fx-border-width: 0 0 1 0;"
        );

        // Perfect alignment with spacers
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);

        // Material label with DARK color for better visibility
        Label materialLabel = new Label("🌱 " + material);
        materialLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18));
        materialLabel.setTextFill(Color.web("#2e7d32"));  // Dark green text
        materialLabel.setStyle(
    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 2, 0, 1, 1);" +
    "-fx-text-fill: black;"
);

         materialLabel.setPrefWidth(350);
        materialLabel.setAlignment(Pos.CENTER_LEFT);


        Region centerSpacer = new Region();
        centerSpacer.setPrefWidth(100);

        // Price container VBox for centering
        VBox priceContainer = new VBox();
        priceContainer.setPrefWidth(350);
        priceContainer.setAlignment(Pos.CENTER);

        // Price label with GREEN background
        Label priceLabel = new Label("💚 " + price);
        priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        priceLabel.setTextFill(Color.WHITE);  // White text
        priceLabel.setStyle(
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 3, 0, 2, 2);" +
            "-fx-background-color: #4caf50;" +  // Green background
            "-fx-background-radius: 12;" +
            "-fx-padding: 10 16 10 16;" +
            "-fx-border-color: #2e7d32;" +  // Dark green border
            "-fx-border-width: 2;" +
            "-fx-border-radius: 12;"
        );
        priceLabel.setAlignment(Pos.CENTER);

        // Add price label to the centered VBox
        priceContainer.getChildren().add(priceLabel);

        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        row.getChildren().addAll(leftSpacer, materialLabel, centerSpacer, priceContainer, rightSpacer);

        // Green hover effects
        row.setOnMouseEntered(e -> {
            row.setStyle(
                "-fx-background-color: #c8e6c8;" +  // Light green on hover
                "-fx-background-radius: " + borderRadius + ";" +
                "-fx-border-color: #4caf50;" +  // Green border on hover
                "-fx-border-width: 0 0 2 0;" +
                "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.4), 10, 0, 0, 5);" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.01;" +
                "-fx-scale-y: 1.01;"
            );
        });

        row.setOnMouseExited(e -> {
            row.setStyle(
                "-fx-background-color: " + backgroundColor + ";" +
                "-fx-background-radius: " + borderRadius + ";" +
                "-fx-border-color: rgba(76, 175, 80, 0.3);" +
                "-fx-border-width: 0 0 1 0;" +
                "-fx-scale-x: 1.0;" +
                "-fx-scale-y: 1.0;"
            );
        });

        return row;
    }
}
