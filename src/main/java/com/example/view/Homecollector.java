package com.example.view;

import com.example.utils.NavButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Homecollector {
    Scene page10Scene, page11Scene, page12Scene, page6Scene, page7Scene, page9Scene, page15Scene, page16Scene, page20Scene, landingScene;
    Stage p10Stage;

    public void setScene(Scene scene) {
        this.page10Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p10Stage = stage;
    }

    public VBox createScene(Runnable back) {
        Button logoutBtn = NavButton.createNavButton("🔓 Logout");
        Button howitworkBtn = NavButton.createNavButton("How It Works");
        Button servicesBtn = NavButton.createNavButton("Services");
        Button enviroBtn = NavButton.createNavButton(" Impact");
        Button AboutUs = NavButton.createNavButton("About us");

        // EXACT ORIGINAL FUNCTIONALITY - NO CHANGES
        logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });

        howitworkBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage11();
                p10Stage.setScene(page11Scene);
            }
        });

        servicesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage6();
                p10Stage.setScene(page6Scene);
            }
        });

        enviroBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage7();
                p10Stage.setScene(page7Scene);
            }
        });

        Button profileBtn = NavButton.createNavButton("Profile");
        profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage16();
                p10Stage.setScene(page16Scene);
            }
        });

        AboutUs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initializePage20();
                p10Stage.setScene(page20Scene);
            }
        });

        // Enhanced Top Title with BLACK text
        Text titleText = new Text("🚛 ScrapSmart");
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
        styleGreenButton(logoutBtn);

        // Header layout with better spacing
        HBox hbLeft = new HBox(titleText);
        hbLeft.setAlignment(Pos.CENTER_LEFT);
        hbLeft.setPadding(new Insets(0, 0, 0, 20));

        HBox hbRight = new HBox(35, profileBtn, AboutUs, howitworkBtn, servicesBtn, enviroBtn, logoutBtn);
        hbRight.setAlignment(Pos.CENTER_RIGHT);
        hbRight.setPadding(new Insets(20, 25, 20, 25));

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
        Label title1 = new Label("🚛 Professional Scrap Collection Services");
        title1.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 42));
        title1.setTextFill(Color.BLACK); // Changed to BLACK
        title1.setWrapText(true);
        title1.setStyle("-fx-text-fill: black !important; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 4, 0, 2, 2);");

        // Enhanced Title 2 - BLACK text
        Label title2 = new Label("Streamline your collection operations with ScrapSmart's advanced tools. Manage pickup requests, track performance, and maximize efficiency while contributing to a sustainable future. Your professional dashboard for smart scrap management.");
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

        // Enhanced Image with shadow - using your original image
        Image image = new Image("/assets/images/homeImg.png");
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
        Label cardsTitle = new Label("⚡ Collector Dashboard");
        cardsTitle.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 36));
        cardsTitle.setTextFill(Color.BLACK); // Changed to BLACK
        cardsTitle.setAlignment(Pos.CENTER);
        cardsTitle.setStyle("-fx-text-fill: black !important; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 4, 0, 2, 2);");

        // Enhanced Cards with your original functionality
        VBox card1 = createEnhancedCard(
            "/assets/images/viewformimag.jpg",
            "View Pickup Request",
            "See all scrap pickup requests\nfrom users with details like\nname, address, material,\nand status."

        );
        
        card1.setOnMouseClicked(event -> {
            initializePage12();
            p10Stage.setScene(page12Scene);
        });

        VBox card2 = createEnhancedCard("assets\\images\\Icons Green Tick Images - Green Thumbs Up Png, Transparent Png , Transparent Png Image - PNGitem.jpg", "Review",
                "See reviews from users");
        card2.setOnMouseClicked(event -> {
            initializePage15();
            p10Stage.setScene(page15Scene);
        });

        VBox card3 = createEnhancedCard("assets/images/priceTag.png", "View Scrap Price List",
                "Check the prices of scrap materials.");
        card3.setOnMouseClicked(event -> {
            initializePage9();
            p10Stage.setScene(page9Scene);
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
            "-fx-padding: 7 14 7 14;" +
            "-fx-effect: dropshadow(gaussian, rgba(76, 175, 80, 0.3), 4, 0, 0, 2);" +
            "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {
            button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #66BB6A, #4CAF50);" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;" +
                "-fx-padding:7 14 7 14;" +
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
                "-fx-padding: 7 14 7 14;" +
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
                "-fx-border-width: 2;" +
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

    // EXACT ORIGINAL NAVIGATION METHODS - NO CHANGES
    private void initializePage11() {
        Aboutuscollect page11 = new Aboutuscollect();
        page11.setStage(p10Stage);
        page11Scene = new Scene(page11.createScene(this::handleBackButton), 1500, 800);
        page11.setScene(page11Scene);
    }

    private void initializePage15() {
        hisCollector page15 = new hisCollector();
        page15.setStage(p10Stage);
        try {
            page15Scene = new Scene(page15.createScene(this::handleBackButton), 1500, 800);
        } catch (Exception e) {
            e.printStackTrace();
        }
        page15.setScene(page11Scene);
    }

    private void initializePage12() {
        Viewform page12 = new Viewform();
        page12.setStage(p10Stage);
        try {
            page12Scene = new Scene(page12.createScene(this::handleBackButton), 1500, 800);
            page12.setScene(page12Scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializePage6() {
        Ourservice page6 = new Ourservice();
        page6.setStage(p10Stage);
        page6Scene = new Scene(page6.createScene(this::handleBackButton), 1500, 800);
        page6.setScene(page6Scene);
    }

    private void initializePage7() {
        EnvironmentalImpact page7 = new EnvironmentalImpact();
        page7.setStage(p10Stage);
        page7Scene = new Scene(page7.createScene(this::handleBackButton), 1500, 800);
        page7.setScene(page7Scene);
    }

    private void initializePage9() {
        RateCard page9 = new RateCard();
        page9.setStage(p10Stage);
        page9Scene = new Scene(page9.createScene(this::handleBackButton), 1500, 800);
        page9.setScene(page9Scene);
    }

    private void initializePage16() {
        ProfCollector page16 = new ProfCollector();
        page16.setStage(p10Stage);
        page16Scene = new Scene(page16.createScene(this::handleBackButton), 1500, 800);
        page16.setScene(page16Scene);
    }

    private void initializePage20() {
        AboutUs page20 = new AboutUs();
        page20.setStage(p10Stage);
        page20Scene = new Scene(page20.createScene(this::handleBackButton), 1500, 800);
        page20.setScene(page16Scene);
    }

    private void handleBackButton() {
        p10Stage.setScene(page10Scene);
    }
}