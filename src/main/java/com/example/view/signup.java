package com.example.view;

import com.example.controller.AuthController;
import com.example.model.Authmodel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signup {
    Scene page4Scene, page17Scene;
    Stage p4Stage;

    public void setScene(Scene scene) {
        this.page4Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p4Stage = stage;
    }

    public VBox createScene(Runnable back) {
        // Title
        Text title = new Text("Sign Up");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        title.setFill(Color.web("#2d5016"));
        
        Text subtitle = new Text("Join us today and get started");
        subtitle.setFont(Font.font("Arial", 14));
        subtitle.setFill(Color.web("#4a7c59"));

        // Email field
        Label emailLabel = new Label("Email Address");
        emailLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        emailLabel.setTextFill(Color.web("#2d5016"));
        
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email address");
        emailField.setPrefHeight(45);
        emailField.setFont(Font.font("Arial", 14));
        emailField.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #a8d5ba;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 0 15px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        // Username field
        Label userLabel = new Label("Username");
        userLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        userLabel.setTextFill(Color.web("#2d5016"));
        
        TextField userField = new TextField();
        userField.setPromptText("Choose a username");
        userField.setPrefHeight(45);
        userField.setFont(Font.font("Arial", 14));
        userField.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #a8d5ba;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 0 15px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        // Password field
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        passwordLabel.setTextFill(Color.web("#2d5016"));
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Create a strong password");
        passwordField.setPrefHeight(45);
        passwordField.setFont(Font.font("Arial", 14));
        passwordField.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #a8d5ba;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 0 15px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        // Confirm password field
        Label confirmLabel = new Label("Confirm Password");
        confirmLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        confirmLabel.setTextFill(Color.web("#2d5016"));
        
        PasswordField passwordField1 = new PasswordField();
        passwordField1.setPromptText("Confirm your password");
        passwordField1.setPrefHeight(45);
        passwordField1.setFont(Font.font("Arial", 14));
        passwordField1.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #a8d5ba;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 0 15px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        // Sign up button
        Button button = new Button("Sign Up");
        button.setPrefHeight(50);
        button.setPrefWidth(200);
        button.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45a049);" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 3);"
        );
        
        // Hover effect for button
        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #45a049, #3d8b40);" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 0, 4);" +
            "-fx-scale-x: 1.05;" +
            "-fx-scale-y: 1.05;"
        ));
        
        button.setOnMouseExited(e -> button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45a049);" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 3);"
        ));

        // Keep original functionality
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                AuthController.signUp(emailField.getText(), passwordField.getText());
                Authmodel auth = new Authmodel(emailField.getText());
                initializePage17(back);
            }
        });

        // Header section
        VBox headerBox = new VBox(8, title, subtitle);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(0, 0, 20, 0));

        // Form section
        VBox formBox = new VBox(15,
                emailLabel, emailField,
                userLabel, userField,
                passwordLabel, passwordField,
                confirmLabel, passwordField1
        );
        formBox.setPadding(new Insets(20, 30, 20, 30));

        // Button section
        HBox buttonBox = new HBox(button);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 10, 0));

        // Card container
        VBox cardContent = new VBox(headerBox, formBox, buttonBox);
        cardContent.setAlignment(Pos.CENTER);
        
        VBox cardBox = new VBox(cardContent);
        cardBox.setPadding(new Insets(40, 40, 40, 40));
        cardBox.setMaxWidth(450);
        cardBox.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.95);" +
            "-fx-border-color: #a8d5ba;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 20px;" +
            "-fx-background-radius: 20px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0, 0, 8);"
        );

        // Root container with gradient background
        VBox root = new VBox(cardBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));
        root.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #e8f5e8,rgb(192, 235, 193),rgb(169, 240, 171));" +
            "-fx-background-size: cover;"
        );

        return root;
    }

    private void initializePage17(Runnable back) {
        CreateProf page17 = new CreateProf();
        page17.setStage(p4Stage);
        page17Scene = new Scene(page17.createScene(back), 1550, 800);
        page17.setScene(page17Scene);
        p4Stage.setScene(page17Scene);
    }
}