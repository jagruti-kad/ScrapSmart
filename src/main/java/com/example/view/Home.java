package com.example.view;

import com.example.utils.NavButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home {
    Scene page1Scene, page2Scene, page3Scene, page5Scene, page6Scene, page7Scene, page8Scene, page9Scene, page13Scene,
            page14Scene, page17Scene, page20Scene;
    Stage p2Stage;

    public void setScene(Scene scene) {
        this.page2Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p2Stage = stage;
    }

    public VBox createScene(Runnable back) {
        Button logoutBtn = NavButton.createNavButton("🔓 Logout");
        Button howitworkBtn = NavButton.createNavButton("How It Works");
        Button servicesBtn = NavButton.createNavButton("Services");
        Button enviroBtn = NavButton.createNavButton(" Impact");
        Button feedbackBtn = NavButton.createNavButton("feedback");
        Button AboutUs = NavButton.createNavButton("About Us");

        logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });

        howitworkBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage3();
                p2Stage.setScene(page3Scene);
            }
        });

        servicesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage6();
                p2Stage.setScene(page6Scene);
            }
        });

        enviroBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage7();
                p2Stage.setScene(page7Scene);
            }
        });

        feedbackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage8();
                p2Stage.setScene(page8Scene);
            }
        });

        Button profileBtn = NavButton.createNavButton("Profile");
        profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage14();
                p2Stage.setScene(page14Scene);
            }
        });

        AboutUs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage20();
                p2Stage.setScene(page20Scene);
            }
        });

        // Enhanced Top Title with BLACK text
        Text titleText = new Text("♻ ScrapSmart");
        titleText.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 48));
        titleText.setFill(Color.BLACK); // Changed to BLACK
        titleText.setStyle(
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 8, 0, 3, 3);" +
                        "-fx-letter-spacing: 3px;");

        // Enhanced navigation buttons styling
        styleGreenButton(profileBtn);
        styleGreenButton(AboutUs);
        styleGreenButton(howitworkBtn);
        styleGreenButton(servicesBtn);
        styleGreenButton(enviroBtn);
        styleGreenButton(feedbackBtn);
        styleGreenButton(logoutBtn);

        // Header layout with better spacing
        HBox hbLeft = new HBox(titleText);
        hbLeft.setAlignment(Pos.CENTER_LEFT);
        hbLeft.setPadding(new Insets(0, 0, 0, 20));

        HBox hbRight = new HBox(25, profileBtn, AboutUs, howitworkBtn, servicesBtn, enviroBtn, feedbackBtn, logoutBtn);
        hbRight.setAlignment(Pos.CENTER_RIGHT);
        hbRight.setPadding(new Insets(15, 20, 15, 20));

        HBox topBar = new HBox();
        topBar.setPadding(new Insets(25, 50, 25, 50));
        topBar.setSpacing(350);
        topBar.getChildren().addAll(hbLeft, hbRight);
        topBar.setStyle(
            "-fx-background-color: linear-gradient(135deg, #E8F5E8, #C8E6C8, #A5D6A7);" +
            "-fx-border-color: #4CAF50;" +
            "-fx-border-width: 0 0 4px 0;" +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 8, 0, 0, 4);"
        );

        // Enhanced Title 1 - BLACK text
        Label title1 = new Label("♻ Paper Prosperity - Yours to Sell");
        title1.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 42));
        title1.setTextFill(Color.BLACK); // Changed to BLACK
        title1.setWrapText(true);
        title1.setStyle("-fx-text-fill: black !important; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 4, 0, 2, 2);");

        // Enhanced Title 2 - BLACK text
        Label title2 = new Label("Transform your discarded paper into quick cash with ScrapSmart - your hassle-free solution for a greener wallet and a cleaner planet. Join thousands of satisfied customers who trust us for their recycling needs.");
        title2.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 20));
        title2.setTextFill(Color.BLACK); // Changed to BLACK
        title2.setWrapText(true);
        title2.setStyle("-fx-text-fill: black !important; -fx-line-spacing: 8px;");

        // Enhanced VBox for text
        VBox textSection = new VBox(25, title1, title2);
        textSection.setAlignment(Pos.CENTER_LEFT);
        textSection.setPadding(new Insets(50, 30, 50, 50));
        textSection.setMaxWidth(750);

        VBox textBox = new VBox(textSection);
        textBox.setPrefWidth(525);
        textBox.setAlignment(Pos.CENTER_LEFT);

        // Enhanced Image with shadow
        Image image = new Image("assets/images/homeImg.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(850);
        imageView.setFitHeight(480);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 15, 0, 0, 8);");

        VBox imageBox = new VBox(imageView);
        imageBox.setPrefWidth(525);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.setPadding(new Insets(20));

        // Enhanced Final layout HBox
        HBox contentBox = new HBox(50, textBox, imageBox);
        contentBox.setPadding(new Insets(40));
        contentBox.setPrefWidth(1100);
        contentBox.setPrefHeight(450);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setStyle(
            "-fx-background-color: linear-gradient(135deg, #E8F5E8, #C8E6C8, #A5D6A7);" +
            "-fx-border-color: #4CAF50;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 20;" +
            "-fx-background-radius: 20;" +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 12, 0, 0, 6);"
        );

        // Enhanced Cards Section - BLACK text
        Label cardsTitle = new Label("⚡ Quick Actions");
        cardsTitle.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 36));
        cardsTitle.setTextFill(Color.BLACK); // Changed to BLACK
        cardsTitle.setAlignment(Pos.CENTER);
        cardsTitle.setStyle("-fx-text-fill: black !important; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 4, 0, 2, 2);");

        VBox card1 = createEnhancedCard("assets/images/pickup.png", "Request Pickup",
                "Schedule a pickup for your scrap");
        card1.setOnMouseClicked(event -> {
            initializePage5();
            p2Stage.setScene(page5Scene);
        });

        VBox card2 = createEnhancedCard("assets/images/track.png", "Track Status",
                "Check your pickup request status");
        card2.setOnMouseClicked(event -> {
            try {
                initializePage13();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            p2Stage.setScene(page13Scene);
        });

        VBox card3 = createEnhancedCard("assets/images/priceTag.png", "View Prices",
                "Check theprices of scrap materials");
        card3.setOnMouseClicked(event -> {
            initializePage9();
            p2Stage.setScene(page9Scene);
        });

        HBox cardsRow = new HBox(60, card1, card2, card3);
        cardsRow.setAlignment(Pos.CENTER);
        cardsRow.setPadding(new Insets(50, 100, 70, 100));

        // Enhanced Cards Section Container
        VBox cardsSection = new VBox(30, cardsTitle, cardsRow);
        cardsSection.setAlignment(Pos.CENTER);
        cardsSection.setPadding(new Insets(40, 0, 40, 0));
        cardsSection.setStyle(
            "-fx-background-color: linear-gradient(135deg, #C8E6C8, #A5D6A7, #81C784);" +
            "-fx-border-color: #4CAF50;" +
            "-fx-border-width: 0 3px 0 3px;" +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.2), 8, 0, 0, 3);"
        );

        // Enhanced Main layout with ScrollPane
        VBox mainContent = new VBox(0, topBar, contentBox, cardsSection);
        mainContent.setStyle("-fx-background-color: linear-gradient(to bottom, #F8FFF8, #E8F5E8);");
                
        // Wrap in ScrollPane to make content scrollable
        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                
        VBox root = new VBox(scrollPane);
        root.setPrefSize(1550, 800);
                
        return root;
    }

    private void styleGreenButton(Button button) {
        button.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 14));
        button.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45A049);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 8;" +
            "-fx-border-radius: 8;" +
            "-fx-padding: 5 10 5 10;" +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 4, 0, 0, 2);" +
            "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {
            button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #66BB6A, #4CAF50);" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-padding: 5 10 5 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(102, 187, 106, 0.4), 6, 0, 0, 3);" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.02;" +
                "-fx-scale-y: 1.02;"
            );
        });

        button.setOnMouseExited(e -> {
            button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45A049);" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-padding: 5 10 5 10;" +
                "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 4, 0, 0, 2);" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.0;" +
                "-fx-scale-y: 1.0;"
            );
        });
    }

    private VBox createEnhancedCard(String iconPath, String titleText, String descriptionText) {
        // Enhanced Icon with shadow
        ImageView icon = new ImageView(new Image(iconPath));
        icon.setFitWidth(90);
        icon.setFitHeight(90);
        icon.setPreserveRatio(true);
        icon.setStyle("-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.4), 6, 0, 2, 2);");

        // Title with BLACK text - force black color
        Label title = new Label(titleText);
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26));
        title.setTextFill(Color.BLACK); // Already BLACK
        title.setWrapText(true);
        title.setAlignment(Pos.CENTER);
        title.setStyle("-fx-text-fill: black !important;");

        // Description with BLACK text - force black color
        Label description = new Label(descriptionText);
        description.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 16));
        description.setTextFill(Color.BLACK); // Already BLACK
        description.setWrapText(false);
        description.setAlignment(Pos.CENTER);
        description.setStyle("-fx-text-fill: black !important;");

        VBox card = new VBox(20, icon, title, description);
        card.setAlignment(Pos.TOP_CENTER);
        card.setPadding(new Insets(30));
        card.setPrefSize(320, 250);
        card.setStyle(
            "-fx-background-color: linear-gradient(135deg, #FFFFFF, #F8FFF8, #E8F5E8);" +
            "-fx-border-color: #4CAF50;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 15;" +
            "-fx-background-radius: 15;" +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 8, 0, 0, 4);"
        );

        // Enhanced hover effects
        card.setOnMouseEntered(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(135deg, #F1F8E9, #E8F5E8, #C8E6C8);" +
                "-fx-border-color: #66BB6A;" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-effect: dropshadow(gaussian, rgba(102, 187, 106, 0.4), 12, 0, 0, 6);" +
                "-fx-cursor: hand;" +
                "-fx-scale-x: 1.03;" +
                "-fx-scale-y: 1.03;"
            );
        });

        card.setOnMouseExited(e -> {
            card.setStyle(
                "-fx-background-color: linear-gradient(135deg, #FFFFFF, #F8FFF8, #E8F5E8);" +
                "-fx-border-color: #4CAF50;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 8, 0, 0, 4);" +
                "-fx-scale-x: 1.0;" +
                "-fx-scale-y: 1.0;"
            );
        });

        return card;
    }

    private VBox createCard(String iconPath, String titleText, String descriptionText) {
        ImageView icon = new ImageView(new Image(iconPath));
        icon.setFitWidth(80);
        icon.setFitHeight(80);
        
        Label title = new Label(titleText);
        title.setFont(Font.font("System", FontWeight.BOLD, 25));
        title.setTextFill(Color.BLACK); // Already BLACK
        
        Label description = new Label(descriptionText);
        description.setFont(Font.font(17));
        description.setTextFill(Color.BLACK); // Changed from GRAY to BLACK
        description.setWrapText(true);

        VBox card = new VBox(10, icon, title, description);
        card.setAlignment(Pos.TOP_CENTER);
        card.setPadding(new Insets(20));
        card.setPrefSize(320, 230);
        card.setStyle(
                "-fx-background-color: #ffffff; -fx-border-color: lightgray; -fx-border-radius: 10; -fx-background-radius: 10;");
        return card;
    }

    private void initializePage3() {
        AboutUsuser page3 = new AboutUsuser();
        page3.setStage(p2Stage);
        page3Scene = new Scene(page3.createScene(this::handleBackButton), 1550, 800);
        page3.setScene(page3Scene);
    }

    private void initializePage5() {
        PickupForm page5 = new PickupForm();
        page5.setStage(p2Stage);
        page5Scene = new Scene(page5.createScene(this::handleBackButton), 1550, 800);
        page5.setScene(page5Scene);
    }

    private void initializePage6() {
        Ourservice page6 = new Ourservice();
        page6.setStage(p2Stage);
        page6Scene = new Scene(page6.createScene(this::handleBackButton), 1550, 800);
        page6.setScene(page6Scene);
    }

    private void initializePage7() {
        EnvironmentalImpact page7 = new EnvironmentalImpact();
        page7.setStage(p2Stage);
        page7Scene = new Scene(page7.createScene(this::handleBackButton), 1550, 800);
        page7.setScene(page7Scene);
    }

    private void initializePage8() {
        feedback page8 = new feedback();
        page8.setStage(p2Stage);
        try {
            page8Scene = new Scene(page8.createScene(this::handleBackButton), 1550, 800);
        } catch (Exception e) {
            e.printStackTrace();
        }
        page8.setScene(page8Scene);
    }

    private void initializePage9() {
        RateCard page9 = new RateCard();
        page9.setStage(p2Stage);
        page9Scene = new Scene(page9.createScene(this::handleBackButton), 1550, 800);
        page9.setScene(page5Scene);
    }

    private void initializePage13() throws Exception {
        hisUser page13 = new hisUser();
        page13.setStage(p2Stage);
        page13Scene = new Scene(page13.createScene(this::handleBackButton), 1550, 800);
        page13.setScene(page13Scene);
    }

    private void initializePage14() {
        ProfUser page14 = new ProfUser();
        page14.setStage(p2Stage);
        page14Scene = new Scene(page14.createScene(this::handleBackButton), 1550, 800);
        page14.setScene(page14Scene);
    }

    private void initializePage20() {
        AboutUs page20 = new AboutUs();
        page20.setStage(p2Stage);
        page20Scene = new Scene(page20.createScene(this::handleBackButton), 1550, 800);
        page20.setScene(page20Scene);
    }

    private void handleBackButton() {
        p2Stage.setScene(page2Scene);
    }
}