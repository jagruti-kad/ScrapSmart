package com.example.view;

import com.example.controller.pickupContoller;
import com.example.model.Pickupmodel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PickupForm {
    Scene page5Scene;
    Stage p5Stage;

    public void setScene(Scene scene) {
        this.page5Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p5Stage = stage;
    }

    public VBox createScene(Runnable back) {
        // Enhanced title with icon
        Label title = new Label("🚛 Request Pickup Service");
        title.setStyle(
            "-fx-font-size: 26px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: white; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 2, 0, 1, 1);"
        );
        
        StackPane titlePane = new StackPane(title);
        titlePane.setStyle(
            "-fx-background-color: linear-gradient(to right, #2e7d32, #388e3c, #43a047); " +
            "-fx-padding: 20; " +
            "-fx-background-radius: 15 15 0 0; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8, 0, 0, 2);"
        );
        titlePane.setMaxWidth(Double.MAX_VALUE);

        // Enhanced form with better styling
        GridPane form = new GridPane();
        form.setVgap(15);
        form.setHgap(15);
        form.setPadding(new Insets(30));
        form.setAlignment(Pos.CENTER);
        form.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #ffffff, #f8f9fa); " +
            "-fx-background-radius: 0 0 15 15;"
        );

        Font inputFont = Font.font("Arial", FontWeight.NORMAL, 16);
        Font labelFont = Font.font("Arial", FontWeight.BOLD, 16);
        String labelStyle = "-fx-text-fill: #2d3748; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 1, 0, 0, 1);";
        String fieldStyle = 
            "-fx-background-color: #ffffff; " +
            "-fx-border-color: #e2e8f0; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 8; " +
            "-fx-background-radius: 8; " +
            "-fx-padding: 10; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 4, 0, 0, 2);";
        
        String fieldFocusStyle = 
            "-fx-background-color: #f7fafc; " +
            "-fx-border-color: #4caf50; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 8; " +
            "-fx-background-radius: 8; " +
            "-fx-padding: 10; " +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.2), 6, 0, 0, 3);";

        double fieldHeight = 45;

        // Enhanced form fields
        TextField nameField = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        nameField.setPromptText("Enter your full name");
        
        TextField phoneField = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        phoneField.setPromptText("Enter phone number");
        
        TextField addressField = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        addressField.setPromptText("Enter complete address");
        
        TextField areaField = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        areaField.setPromptText("Enter area/locality");
        
        TextField cityField = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        cityField.setPromptText("Enter city name");
        
        TextField pincodeField = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        pincodeField.setPromptText("Enter pincode");

        // Enhanced ComboBox
        ComboBox<String> scrapTypeCombo = new ComboBox<>();
        scrapTypeCombo.getItems().addAll("📰 Newspaper", "📓 Notebook", "🥤 Plastic", "🔩 Metal", "📦 Others");
        scrapTypeCombo.setValue("📰 Newspaper");
        scrapTypeCombo.setPrefHeight(fieldHeight);
        scrapTypeCombo.setStyle(
            fieldStyle + 
            "-fx-font-size: 16px; " +
            "-fx-font-family: Arial;"
        );
        scrapTypeCombo.setOnMouseEntered(e -> scrapTypeCombo.setStyle(
            fieldFocusStyle + 
            "-fx-font-size: 16px; " +
            "-fx-font-family: Arial;"
        ));
        scrapTypeCombo.setOnMouseExited(e -> scrapTypeCombo.setStyle(
            fieldStyle + 
            "-fx-font-size: 16px; " +
            "-fx-font-family: Arial;"
        ));

        TextField pickupDate = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        pickupDate.setPromptText("DD-MM-YYYY");
        
        TextField pickupTime = createStyledTextField(fieldHeight, inputFont, fieldStyle, fieldFocusStyle);
        pickupTime.setPromptText("HH:MM (24-hour format)");

        // Enhanced labels with icons
        Label nameLabel = createStyledLabel("👤 Name:", labelFont, labelStyle);
        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);

        Label phoneLabel = createStyledLabel("📱 Phone:", labelFont, labelStyle);
        form.add(phoneLabel, 0, 1);
        form.add(phoneField, 1, 1);

        Label addressLabel = createStyledLabel("🏠 Address:", labelFont, labelStyle);
        form.add(addressLabel, 0, 2);
        form.add(addressField, 1, 2);

        Label areaLabel = createStyledLabel("📍 Area:", labelFont, labelStyle);
        form.add(areaLabel, 0, 3);
        form.add(areaField, 1, 3);

        Label cityLabel = createStyledLabel("🏙️ City:", labelFont, labelStyle);
        form.add(cityLabel, 0, 4);
        form.add(cityField, 1, 4);

        Label pincodeLabel = createStyledLabel("📮 Pincode:", labelFont, labelStyle);
        form.add(pincodeLabel, 0, 5);
        form.add(pincodeField, 1, 5);

        Label scrapTypeLabel = createStyledLabel("♻️ Type of Scrap:", labelFont, labelStyle);
        form.add(scrapTypeLabel, 0, 6);
        form.add(scrapTypeCombo, 1, 6);

        Label dateLabel = createStyledLabel("📅 Preferred Pickup Date:", labelFont, labelStyle);
        form.add(dateLabel, 0, 7);
        form.add(pickupDate, 1, 7);

        Label timeLabel = createStyledLabel("⏰ Preferred Pickup Time:", labelFont, labelStyle);
        form.add(timeLabel, 0, 8);
        form.add(pickupTime, 1, 8);

        // Enhanced submit button
        Button submitBtn = new Button("🚀 Submit Request");
        submitBtn.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        submitBtn.setPrefHeight(50);
        submitBtn.setPrefWidth(200);
        submitBtn.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32); " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 25; " +
            "-fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 3); " +
            "-fx-cursor: hand;"
        );
        
        submitBtn.setOnMouseEntered(e -> submitBtn.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #66bb6a, #43a047); " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 25; " +
            "-fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 8, 0, 0, 4); " +
            "-fx-cursor: hand; " +
            "-fx-scale-x: 1.05; " +
            "-fx-scale-y: 1.05;"
        ));
        
        submitBtn.setOnMouseExited(e -> submitBtn.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #43a047, #2e7d32); " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 25; " +
            "-fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 3); " +
            "-fx-cursor: hand; " +
            "-fx-scale-x: 1.0; " +
            "-fx-scale-y: 1.0;"
        ));

        VBox.setMargin(submitBtn, new Insets(20, 0, 30, 0));

        // Keep the exact same functionality
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                String scrapType = scrapTypeCombo.getValue();  // ✅ Correctly fetch scrap type at button click
                System.out.println("Selected Scrap Type: " + scrapType);
                Pickupmodel pk = new Pickupmodel(
                        nameField.getText(),
                        phoneField.getText(),
                        addressField.getText(),
                        areaField.getText(),
                        cityField.getText(),
                        pincodeField.getText(),
                        scrapType,  // ✅ scrap passed directly here
                        pickupDate.getText(),
                        pickupTime.getText()
                );
                try {
                    pickupContoller.storePickUp(
                            pk.getName(),
                            pk.getPhone_no(),
                            pk.getAddress(),
                            pk.getArea(),
                            pk.getCity(),
                            pk.getPincode(),
                            pk.getScrapType(),
                            pk.getDatepicker(),
                            pk.getPickuptime()
                    );
                    System.out.println("Pickup Request Submitted!");
                    back.run(); // Navigate back
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Enhanced card container
        VBox card = new VBox(titlePane, form, submitBtn);
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(750);
        card.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #ffffff, #f8f9fa); " +
            "-fx-background-radius: 15; " +
            "-fx-border-radius: 15; " +
            "-fx-border-color: linear-gradient(to right, #4caf50, #66bb6a); " +
            "-fx-border-width: 3; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0, 0, 8);"
        );

        // Enhanced root container
        VBox root = new VBox(card);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #e8f5e8, #d4f1d4, #c8e6c8);"
        );

        return root;
    }

    private TextField createStyledTextField(double height, Font font, String normalStyle, String focusStyle) {
        TextField field = new TextField();
        field.setPrefHeight(height);
        field.setFont(font);
        field.setStyle(normalStyle);
        
        field.setOnMouseEntered(e -> field.setStyle(focusStyle));
        field.setOnMouseExited(e -> {
            if (!field.isFocused()) {
                field.setStyle(normalStyle);
            }
        });
        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                field.setStyle(focusStyle);
            } else {
                field.setStyle(normalStyle);
            }
        });
        
        return field;
    }

    private Label createStyledLabel(String text, Font font, String style) {
        Label label = new Label(text);
        label.setFont(font);
        label.setStyle(style);
        return label;
    }
}
