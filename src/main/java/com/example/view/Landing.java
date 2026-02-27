package com.example.view;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Landing extends Application {
    Scene landScene, page1Scene;
    Stage landStage;

    public void setLandScene(Scene landScene) {
        this.landScene = landScene;
    }

    public void setLandStage(Stage landStage) {
        this.landStage = landStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.landStage = primaryStage;

        // Create main title with enhanced styling
        Text mainTitle = new Text("Welcome to");
        mainTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        mainTitle.setFill(Color.web("#2d5016"));
        mainTitle.setEffect(createEnhancedDropShadow());

        Text appName = new Text("ScrapSmart");
        appName.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 48));
        appName.setFill(Color.web("#1B4332"));
        appName.setEffect(createGlowEffect());

        Text subtitle = new Text("Your Smart Scrap Management Solution");
        subtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        subtitle.setFill(Color.web("#4a7c59"));
        subtitle.setEffect(createSubtleDropShadow());

        // Enhanced "Get Started" button with your original functionality
        Text getStartedBtn = new Text("Get Started");
        getStartedBtn.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 32));
        getStartedBtn.setFill(Color.WHITE);
        
        // Create button background
        Rectangle buttonBg = new Rectangle(280, 70);
        buttonBg.setFill(LinearGradient.valueOf("linear-gradient(to right, #4CAF50, #45a049)"));
        buttonBg.setArcWidth(35);
        buttonBg.setArcHeight(35);
        buttonBg.setEffect(createButtonShadow());

        // Stack button text on background
        StackPane getStartedButton = new StackPane();
        getStartedButton.getChildren().addAll(buttonBg, getStartedBtn);
        getStartedButton.setAlignment(Pos.CENTER);

        // Enhanced hover effects
        getStartedButton.setOnMouseEntered(e -> {
            buttonBg.setFill(LinearGradient.valueOf("linear-gradient(to right, #45a049, #3d8b40)"));
            buttonBg.setEffect(createEnhancedButtonShadow());
            
            // Scale animation
            ScaleTransition scaleIn = new ScaleTransition(Duration.millis(200), getStartedButton);
            scaleIn.setToX(1.05);
            scaleIn.setToY(1.05);
            scaleIn.play();
            
            getStartedBtn.setStyle("-fx-cursor: hand;");
        });

        getStartedButton.setOnMouseExited(e -> {
            buttonBg.setFill(LinearGradient.valueOf("linear-gradient(to right, #4CAF50, #45a049)"));
            buttonBg.setEffect(createButtonShadow());
            
            // Scale back animation
            ScaleTransition scaleOut = new ScaleTransition(Duration.millis(200), getStartedButton);
            scaleOut.setToX(1.0);
            scaleOut.setToY(1.0);
            scaleOut.play();
        });

        // EXACT ORIGINAL FUNCTIONALITY - NO CHANGES
        getStartedButton.setOnMouseClicked(event -> {
            initializePage1();
            landStage.setScene(page1Scene);
        });

        // Create decorative elements
        VBox decorativeElements = createDecorativeElements();

        // Main content container
        VBox titleContainer = new VBox(15);
        titleContainer.getChildren().addAll(mainTitle, appName, subtitle);
        titleContainer.setAlignment(Pos.CENTER);

        VBox buttonContainer = new VBox(getStartedButton);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setPadding(new Insets(40, 0, 0, 0));

        VBox mainContent = new VBox(30);
        mainContent.getChildren().addAll(titleContainer, buttonContainer);
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setPadding(new Insets(25, 50, 25, 50));

        // Create glass morphism card
        VBox contentCard = new VBox(mainContent);
        contentCard.setPadding(new Insets(40, 60, 40, 60));
        contentCard.setMaxWidth(600);
        contentCard.setMaxHeight(600);
        contentCard.setAlignment(Pos.CENTER);
        contentCard.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15);" +
            "-fx-border-color: rgba(255, 255, 255, 0.3);" +
            "-fx-border-width: 1px;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 20, 0, 0, 10);"
        );

        // Main layout with background
        StackPane mainLayout = new StackPane();
        
        // Background with gradient and image handling
        VBox backgroundContainer = new VBox();
        String imageUrl = null;
        java.net.URL imgResource = getClass().getResource("/assets/images/landingPage2.png");
        
        if (imgResource != null) {
            imageUrl = imgResource.toExternalForm();
            backgroundContainer.setStyle(
                "-fx-background-image: url('" + imageUrl + "');" +
                "-fx-background-size: cover;" +
                "-fx-background-position: center;" +
                "-fx-background-color: linear-gradient(135deg, " +
                "#e8f5e8 0%, " +
                "#c8e6c9 25%, " +
                "#a5d6a7 50%, " +
                "#81c784 75%, " +
                "#66bb6a 100%);"
            );
        } else {
            System.err.println("Image not found: assets/images/landingPage2.png");
            backgroundContainer.setStyle(
                "-fx-background-color: linear-gradient(135deg, " +
                "#e8f5e8 0%, " +
                "#c8e6c9 25%, " +
                "#a5d6a7 50%, " +
                "#81c784 75%, " +
                "#66bb6a 100%);"
            );
        }

        // Add overlay for better text readability
        Rectangle overlay = new Rectangle(1550, 800);
overlay.setFill(Color.web("#ffffff", 0.4)); // Light overlay
backgroundContainer.setEffect(new GaussianBlur(8)); // Optional blur

        

        mainLayout.getChildren().addAll(backgroundContainer, overlay, decorativeElements, contentCard);
        mainLayout.setAlignment(Pos.CENTER);

        // Add entrance animations
        addEntranceAnimations(titleContainer, buttonContainer, contentCard);

        landScene = new Scene(mainLayout, 1550, 800);
        landStage.setScene(landScene);
        landStage.setTitle("ScrapSmart - Landing Page");
        landStage.show();
    }

    private VBox createDecorativeElements() {
        VBox decorativeContainer = new VBox();
        
        // Create floating circles for decoration
        for (int i = 0; i < 8; i++) {
            Circle circle = new Circle();
            circle.setRadius(Math.random() * 30 + 10);
            circle.setFill(Color.web("#4CAF50", 0.1 + Math.random() * 0.2));
            circle.setEffect(new GaussianBlur(2));
            
            // Random positioning
            circle.setTranslateX((Math.random() - 0.5) * 1400);
            circle.setTranslateY((Math.random() - 0.5) * 700);
            
            decorativeContainer.getChildren().add(circle);
        }
        
        return decorativeContainer;
    }

    private void addEntranceAnimations(VBox titleContainer, VBox buttonContainer, VBox contentCard) {
        // Fade in animation for the card
        FadeTransition cardFade = new FadeTransition(Duration.millis(1000), contentCard);
        cardFade.setFromValue(0.0);
        cardFade.setToValue(1.0);
        
        // Slide up animation for title
        TranslateTransition titleSlide = new TranslateTransition(Duration.millis(800), titleContainer);
        titleSlide.setFromY(50);
        titleSlide.setToY(0);
        
        // Slide up animation for button (delayed)
        TranslateTransition buttonSlide = new TranslateTransition(Duration.millis(800), buttonContainer);
        buttonSlide.setFromY(50);
        buttonSlide.setToY(0);
        buttonSlide.setDelay(Duration.millis(300));
        
        // Play animations
        cardFade.play();
        titleSlide.play();
        buttonSlide.play();
    }

    private DropShadow createEnhancedDropShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(8.0);
        shadow.setOffsetX(2.0);
        shadow.setOffsetY(2.0);
        shadow.setColor(Color.web("#000000", 0.3));
        return shadow;
    }

    private DropShadow createGlowEffect() {
        DropShadow glow = new DropShadow();
        glow.setRadius(15.0);
        glow.setOffsetX(0.0);
        glow.setOffsetY(0.0);
        glow.setColor(Color.web("#4CAF50", 0.6));
        return glow;
    }

    private DropShadow createSubtleDropShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(3.0);
        shadow.setOffsetX(1.0);
        shadow.setOffsetY(1.0);
        shadow.setColor(Color.web("#000000", 0.2));
        return shadow;
    }

    private DropShadow createButtonShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(10.0);
        shadow.setOffsetX(0.0);
        shadow.setOffsetY(5.0);
        shadow.setColor(Color.web("#000000", 0.3));
        return shadow;
    }

    private DropShadow createEnhancedButtonShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(15.0);
        shadow.setOffsetX(0.0);
        shadow.setOffsetY(8.0);
        shadow.setColor(Color.web("#000000", 0.4));
        return shadow;
    }

    // EXACT ORIGINAL NAVIGATION METHODS - NO CHANGES
    private void initializePage1() {
        LoginPage login = new LoginPage();
        login.setStage(landStage);
        page1Scene = new Scene(login.createScene(() -> {
            landStage.setScene(landScene);
        }), 1550, 800);
        login.setScene(page1Scene);
    }

    private void handleBackButton() {
        landStage.setScene(landScene);
    }
}