package com.example.view;

import com.example.controller.AuthController;
import com.example.model.Authmodel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage {
    Scene page1Scene, page2Scene, page4Scene, page10Scene, page17Scene;
    Stage PrimaryStage;

    public void setScene(Scene scene) {
        this.page1Scene = scene;
    }

    public void setStage(Stage stage) {
        this.PrimaryStage = stage;
    }

    public VBox createScene(Runnable back) {
        // Enhanced title section
        Text welcomeText = new Text("Welcome Back");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        welcomeText.setFill(Color.web("#2d5016"));
        welcomeText.setEffect(createDropShadow());

        Text subtitleText = new Text("Sign in to continue to ScrapSmart");
        subtitleText.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        subtitleText.setFill(Color.web("#4a7c59"));

        // Logo container with enhanced styling
        VBox logoContainer = new VBox();
        Image logo = new Image("assets/images/ScrapSmart.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(100);
        logoView.setFitHeight(100);
        logoView.setPreserveRatio(true);
        logoView.setEffect(createEnhancedDropShadow());
        
        logoContainer.getChildren().add(logoView);
        logoContainer.setAlignment(Pos.CENTER);
        logoContainer.setPadding(new Insets(0, 0, 20, 0));

        // Email field with modern styling
        Label emailLabel = new Label("Email Address");
        emailLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        emailLabel.setTextFill(Color.web("#2d5016"));
        emailLabel.setAlignment(Pos.CENTER_LEFT); // Add this line

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

        // Focus effects for email field
        emailField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                emailField.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #4CAF50;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 8px;" +
                    "-fx-background-radius: 8px;" +
                    "-fx-padding: 0 15px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 8, 0, 0, 2);"
                );
            } else {
                emailField.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #a8d5ba;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 8px;" +
                    "-fx-background-radius: 8px;" +
                    "-fx-padding: 0 15px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
                );
            }
        });

        // Password field with modern styling
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        passwordLabel.setTextFill(Color.web("#2d5016"));
        passwordLabel.setAlignment(Pos.CENTER_LEFT); // Add this line

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
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

        // Focus effects for password field
        passwordField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                passwordField.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #4CAF50;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 8px;" +
                    "-fx-background-radius: 8px;" +
                    "-fx-padding: 0 15px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 8, 0, 0, 2);"
                );
            } else {
                passwordField.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #a8d5ba;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 8px;" +
                    "-fx-background-radius: 8px;" +
                    "-fx-padding: 0 15px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
                );
            }
        });

        // Login type selector with enhanced styling
        Label loginTypeLabel = new Label("Login Type");
        loginTypeLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        loginTypeLabel.setTextFill(Color.web("#2d5016"));
        loginTypeLabel.setAlignment(Pos.CENTER_LEFT); // Add this line

        ComboBox<String> loginOptions = new ComboBox<>();
        loginOptions.getItems().addAll("User Login", "Collector Login");
        loginOptions.setPromptText("Select your login type");
        loginOptions.setPrefHeight(45);
        loginOptions.setMaxWidth(Double.MAX_VALUE);
        loginOptions.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #a8d5ba;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-font-size: 14px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        // Focus effects for combo box
        loginOptions.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                loginOptions.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #4CAF50;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 8px;" +
                    "-fx-background-radius: 8px;" +
                    "-fx-font-size: 14px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 8, 0, 0, 2);"
                );
            } else {
                loginOptions.setStyle(
                    "-fx-background-color: white;" +
                    "-fx-border-color: #a8d5ba;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 8px;" +
                    "-fx-background-radius: 8px;" +
                    "-fx-font-size: 14px;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);"
                );
            }
        });

        // Enhanced login button
        Button loginButton = new Button("Sign In");
        loginButton.setPrefHeight(50);
        loginButton.setMaxWidth(Double.MAX_VALUE);
        loginButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        loginButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45a049);" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 3);"
        );

        // Hover effects for login button
        loginButton.setOnMouseEntered(e -> {
            loginButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #45a049, #3d8b40);" +
                "-fx-text-fill: white;" +
                "-fx-border-radius: 25px;" +
                "-fx-background-radius: 25px;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 0, 4);" +
                "-fx-scale-x: 1.02;" +
                "-fx-scale-y: 1.02;"
            );
        });

        loginButton.setOnMouseExited(e -> {
            loginButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45a049);" +
                "-fx-text-fill: white;" +
                "-fx-border-radius: 25px;" +
                "-fx-background-radius: 25px;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 3);"
            );
        });

        // EXACT ORIGINAL FUNCTIONALITY - NO CHANGES
        loginButton.setOnAction(e -> {
            AuthController.signIn(emailField.getText(), passwordField.getText());
            Authmodel auth = new Authmodel(emailField.getText());
            String selected = loginOptions.getValue();
            if (selected == null) return;
            switch (selected) {
                case "User Login":
                    initializePage2();
                    PrimaryStage.setScene(page2Scene);
                    break;
                case "Collector Login":
                    initializePage10();
                    PrimaryStage.setScene(page10Scene);
                    break;
            }
        });

        // Enhanced signup button
        Button signupButton = new Button("Don't have an account? Sign Up");
        signupButton.setPrefHeight(45);
        signupButton.setMaxWidth(Double.MAX_VALUE);
        signupButton.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        signupButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: #4CAF50;" +
            "-fx-border-color: #4CAF50;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-cursor: hand;"
        );

        // Hover effects for signup button
        signupButton.setOnMouseEntered(e -> {
            signupButton.setStyle(
                "-fx-background-color: #4CAF50;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: #4CAF50;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 25px;" +
                "-fx-background-radius: 25px;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0, 0, 2);"
            );
        });

        signupButton.setOnMouseExited(e -> {
            signupButton.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #4CAF50;" +
                "-fx-border-color: #4CAF50;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 25px;" +
                "-fx-background-radius: 25px;" +
                "-fx-cursor: hand;"
            );
        });

        // EXACT ORIGINAL FUNCTIONALITY - NO CHANGES
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage4();
                PrimaryStage.setScene(page4Scene);
            }
        });

        // Header section
        VBox headerBox = new VBox(8, welcomeText, subtitleText);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(0, 0, 25, 0));

        // Form section with left-aligned labels
        VBox formBox = new VBox(15,
                emailLabel, emailField,
                passwordLabel, passwordField,
                loginTypeLabel, loginOptions
        );
        formBox.setPadding(new Insets(20, 30, 20, 30));
        // Add this line to ensure labels are left-aligned
        formBox.setAlignment(Pos.TOP_LEFT);

        // Button section
        VBox buttonBox = new VBox(15, loginButton, signupButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 10, 0));

        // Card content - keep header centered but form left-aligned
        VBox cardContent = new VBox();
        cardContent.getChildren().addAll(headerBox, formBox, buttonBox);
        // Remove the center alignment for the entire card content
        // cardContent.setAlignment(Pos.CENTER); // Remove this line

        // Enhanced card container
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

        // Main container
        VBox mainContainer = new VBox(20);
        mainContainer.getChildren().addAll(logoContainer, cardBox);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(50));

        // Root container with beautiful gradient background
        VBox rootContainer = new VBox();
        rootContainer.getChildren().add(mainContainer);
        rootContainer.setAlignment(Pos.CENTER);
        rootContainer.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, #e8f5e8,rgb(168, 215, 169),rgb(156, 238, 159));" +
            "-fx-background-size: cover;"
        );

        return rootContainer;
    }

    private DropShadow createDropShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(1.0);
        dropShadow.setOffsetY(1.0);
        dropShadow.setColor(Color.color(0.0, 0.0, 0.0, 0.3));
        return dropShadow;
    }

    private DropShadow createEnhancedDropShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(8.0);
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(Color.color(0.0, 0.0, 0.0, 0.2));
        return dropShadow;
    }

    // EXACT ORIGINAL NAVIGATION METHODS - NO CHANGES AT ALL
    private void initializePage2() {
        Home page2 = new Home();
        page2.setStage(PrimaryStage);
        page1Scene = PrimaryStage.getScene();
        page2Scene = new Scene(page2.createScene(this::handleBackButton), 1550, 800);
        page2.setScene(page2Scene);
    }

    private void initializePage4() {
        signup page4 = new signup();
        page4.setStage(PrimaryStage);
        page4Scene = new Scene(page4.createScene(() -> {
            CreateProf page17 = new CreateProf();
            page17.setStage(PrimaryStage);
            page17Scene = new Scene(page17.createScene(this::handleBackButton), 1550, 800);
            page17.setScene(page17Scene);
            PrimaryStage.setScene(page17Scene);
        }), 1550, 800);
        page4.setScene(page4Scene);
    }

    private void initializePage10() {
        Homecollector page10 = new Homecollector();
        page10.setStage(PrimaryStage);
        page10Scene = new Scene(page10.createScene(this::handleBackButton), 1550, 800);
        page10.setScene(page10Scene);
    }

    private void handleBackButton() {
        PrimaryStage.setScene(page1Scene);
    }
}
