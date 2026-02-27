package com.example.view;

import java.util.List;
import java.util.Map;
import com.example.controller.FeedController;
import com.example.model.FeedModel;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class feedback {
    Scene page8Scene;
    Stage p8Stage;

    public void setScene(Scene scene) {
        this.page8Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p8Stage = stage;
    }

    public VBox createScene(Runnable back) throws Exception {
        VBox mainVBox = new VBox(20);

        List<Map<String, Object>> feedList = FeedController.feedMapList();
        for (Map<String, Object> feedback : feedList) {
            Text user = new Text("User: " + feedback.get("User"));
            Text rate = new Text("Rate: " + feedback.get("Rate"));
            Text comment = new Text("Comment: " + feedback.get("Comment"));
            for (Text t : new Text[]{user, rate, comment}) {
                t.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 14));
                t.setFill(Color.web("#2F4F2F"));
            }
        }

        StackPane feedbackCard = createInnovativeFeedbackCard(back);
        VBox root = new VBox(feedbackCard);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        // Green background
        mainVBox.setStyle(
            "-fx-background-color: " +
            "radial-gradient(center 50% 50%, radius 80%, " +
            "#1B5E20 0%, #2E7D32 20%, #388E3C 40%, #43A047 60%, " +
            "#4CAF50 80%, #66BB6A 100%), " +
            "linear-gradient(45deg, " +
            "#0D4F0D 0%, #1B5E20 25%, #2E7D32 50%, #388E3C 75%, #43A047 100%);"
        );

        StackPane decorativeLayer = createFloatingElements();
        StackPane finalContainer = new StackPane();
        finalContainer.getChildren().addAll(decorativeLayer, root);

        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.getChildren().add(finalContainer);

        return mainVBox;
    }

    private StackPane createInnovativeFeedbackCard(Runnable back) {
        StackPane cardContainer = new StackPane();

        Rectangle cardShadow = new Rectangle(500, 650);
        cardShadow.setFill(Color.web("#1B5E20", 0.2));
        cardShadow.setArcWidth(25);
        cardShadow.setArcHeight(25);
        cardShadow.setTranslateX(6);
        cardShadow.setTranslateY(6);

        Rectangle cardBase = new Rectangle(500, 650);
        LinearGradient cardGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.web("#FFFFFF", 0.98)),
            new Stop(0.3, Color.web("#F1F8E9", 0.95)),
            new Stop(0.7, Color.web("#E8F5E8", 0.92)),
            new Stop(1, Color.web("#DCEDC8", 0.90))
        );
        cardBase.setFill(cardGradient);
        cardBase.setArcWidth(20);
        cardBase.setArcHeight(20);

        Rectangle borderGlow = new Rectangle(505, 655);
        LinearGradient borderGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.web("#1B5E20")),
            new Stop(0.33, Color.web("#2E7D32")),
            new Stop(0.66, Color.web("#388E3C")),
            new Stop(1, Color.web("#43A047"))
        );
        borderGlow.setStroke(borderGradient);
        borderGlow.setStrokeWidth(3);
        borderGlow.setFill(Color.TRANSPARENT);
        borderGlow.setArcWidth(23);
        borderGlow.setArcHeight(23);

        DropShadow cardGlow = new DropShadow();
        cardGlow.setColor(Color.web("#4CAF50", 0.5));
        cardGlow.setOffsetX(0);
        cardGlow.setOffsetY(0);
        cardGlow.setRadius(18);
        borderGlow.setEffect(cardGlow);

        VBox headerSection = createHeaderSection();
        VBox formContent = createFormContent(back);

        VBox cardContent = new VBox(25, headerSection, formContent);
        cardContent.setAlignment(Pos.CENTER);
        cardContent.setPadding(new Insets(40, 50, 40, 50));
        cardContent.setMaxWidth(450);

        cardContainer.getChildren().addAll(cardShadow, cardBase, borderGlow, cardContent);
        addCardAnimation(cardContainer);

        return cardContainer;
    }

    private VBox createHeaderSection() {
        Circle iconBg = new Circle(40);
        RadialGradient iconGradient = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.web("#4CAF50")),
            new Stop(0.7, Color.web("#388E3C")),
            new Stop(1, Color.web("#2E7D32"))
        );
        iconBg.setFill(iconGradient);

        Text iconText = new Text("💬");
        iconText.setFont(Font.font("Segoe UI Emoji", 32));
        StackPane iconContainer = new StackPane(iconBg, iconText);

        Text heading = new Text("Share Your Experience");
        heading.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        heading.setFill(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.web("#1B5E20")),
            new Stop(0.5, Color.web("#2E7D32")),
            new Stop(1, Color.web("#388E3C"))
        ));

        Text subtitle = new Text("Your feedback helps us improve our services");
        subtitle.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 14));
        subtitle.setFill(Color.web("#43A047"));
        subtitle.setTextAlignment(TextAlignment.CENTER);
        subtitle.setWrappingWidth(350);

        Rectangle decorLine = new Rectangle(120, 3);
        decorLine.setFill(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.TRANSPARENT),
            new Stop(0.5, Color.web("#4CAF50")),
            new Stop(1, Color.TRANSPARENT)
        ));
        decorLine.setArcWidth(3);
        decorLine.setArcHeight(3);

        VBox headerBox = new VBox(15, iconContainer, heading, decorLine, subtitle);
        headerBox.setAlignment(Pos.CENTER);

        return headerBox;
    }

    private VBox createFormContent(Runnable back) {
        VBox usernameSection = createInputSection("👤", "Username", "Enter your username");
        TextField userField = (TextField) usernameSection.getChildren().get(1);

        VBox ratingSection = createInputSection("⭐", "Rating (1-5)", "Rate our service");
        TextField rateField = (TextField) ratingSection.getChildren().get(1);

        VBox commentSection = createInputSection("💭", "Comments", "Share your thoughts...");
        TextField commentField = (TextField) commentSection.getChildren().get(1);
        commentField.setPrefHeight(80);

        Text acceptedMsg = new Text();
        acceptedMsg.setFont(Font.font("Segoe UI", FontWeight.MEDIUM, 13));
        acceptedMsg.setTextAlignment(TextAlignment.CENTER);
        acceptedMsg.setWrappingWidth(350);

        Button submitButton = createSubmitButton("Submit Feedback", userField, rateField, commentField, acceptedMsg, back);

        VBox formBox = new VBox(20, usernameSection, ratingSection, commentSection, submitButton, acceptedMsg);
        formBox.setAlignment(Pos.CENTER);
        formBox.setMaxWidth(400);

        return formBox;
    }

    private VBox createInputSection(String icon, String label, String placeholder) {
        HBox labelBox = new HBox(8);
        Text iconText = new Text(icon);
        iconText.setFont(Font.font("Segoe UI Emoji", 16));

        Text labelText = new Text(label);
        labelText.setFont(Font.font("Segoe UI", FontWeight.MEDIUM, 15));
        labelText.setFill(Color.web("#1B5E20"));

        labelBox.getChildren().addAll(iconText, labelText);
        labelBox.setAlignment(Pos.CENTER_LEFT);

        TextField inputField = new TextField();
        inputField.setPromptText(placeholder);
        inputField.setPrefHeight(40);
        inputField.setMaxWidth(350);
        inputField.setFont(Font.font("Segoe UI", 14));
        inputField.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #FFFFFF, #F1F8E9);" +
            "-fx-border-color: #4CAF50;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10;" +
            "-fx-text-fill: #2F4F2F;" +
            "-fx-effect: dropshadow(gaussian, rgba(76,175,80,0.3), 4, 0, 0, 2);"
        );

        VBox section = new VBox(6, labelBox, inputField);
        section.setAlignment(Pos.CENTER);
        return section;
    }

    private Button createSubmitButton(String text, TextField userField, TextField rateField,
                                      TextField commentField, Text acceptedMsg, Runnable back) {
        Button button = new Button(text);
        button.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        button.setPrefSize(220, 50);

        // green color gradient
        button.setStyle(
            "-fx-background-color: linear-gradient(135deg, #57c68dff, #44b880ff, #adfc80ff);" +
            "-fx-text-fill: white;" +
            "-fx-border-radius: 25;" +
            "-fx-background-radius: 25;" +
            "-fx-effect: dropshadow(gaussian, rgba(33, 243, 75, 0.71), 12, 0, 0, 6);" +
            "-fx-cursor: hand;" +
            "-fx-font-weight: bold;"
        );

        button.setOnMouseEntered(e -> button.setScaleX(1.05));
        button.setOnMouseExited(e -> button.setScaleX(1.0));

        button.setOnAction(e -> {
            FeedModel fm = new FeedModel(
                userField.getText(),
                rateField.getText(),
                commentField.getText()
            );
            try {
                FeedController.storeFeed(fm.getUser(), fm.getRate(), fm.getComment());
                acceptedMsg.setText("🎉 Thank you! Your feedback has been submitted successfully!");
                acceptedMsg.setFill(Color.web("#00C853"));

                userField.clear();
                rateField.clear();
                commentField.clear();

                back.run();
            } catch (Exception ex) {
                ex.printStackTrace();
                acceptedMsg.setText("❌ Oops! Something went wrong. Please try again.");
                acceptedMsg.setFill(Color.web("#DC143C"));
            }
        });

        return button;
    }

    private StackPane createFloatingElements() {
        StackPane decorLayer = new StackPane();
        String[] greenShades = {"#1B5E20", "#2E7D32", "#388E3C", "#43A047", "#4CAF50", "#66BB6A"};

        for (int i = 0; i < 12; i++) {
            Circle floatingCircle = new Circle(6 + Math.random() * 15);
            floatingCircle.setFill(Color.web(greenShades[i % greenShades.length], 0.1 + Math.random() * 0.15));
            floatingCircle.setTranslateX((Math.random() - 0.5) * 700);
            floatingCircle.setTranslateY((Math.random() - 0.5) * 500);

            TranslateTransition float1 = new TranslateTransition(Duration.seconds(3 + Math.random() * 8), floatingCircle);
            float1.setByY(-15 - Math.random() * 30);
            float1.setByX((Math.random() - 0.5) * 50);
            float1.setCycleCount(-1);
            float1.setAutoReverse(true);
            float1.play();

            decorLayer.getChildren().add(floatingCircle);
        }

        return decorLayer;
    }

    private void addCardAnimation(StackPane card) {
        card.setOpacity(0);
        card.setScaleX(0.9);
        card.setScaleY(0.9);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.8), card);
        fadeIn.setToValue(1);

        ScaleTransition scaleIn = new ScaleTransition(Duration.seconds(0.8), card);
        scaleIn.setToX(1.0);
        scaleIn.setToY(1.0);

        fadeIn.play();
        scaleIn.play();
    }
}
