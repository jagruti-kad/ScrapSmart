package com.example.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EnvironmentalImpact{
        Scene page7Scene;
        Stage p7Stage;

    public void setScene(Scene scene) {
        this.page7Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p7Stage = stage;
    }

    public VBox createScene(Runnable back) {
        // Root container
        HBox root = new HBox(30);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f9f9f9;");
        root.setAlignment(Pos.CENTER);

        // Left side: image
        ImageView imageView = new ImageView(new Image("assets\\images\\threeR.jpeg")); 
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        // Right side: Card VBox
        VBox card = new VBox(60);
        card.setPadding(new Insets(30));
        card.setStyle(
            "-fx-background-color: #f2dcdcff;" +
            "-fx-background-radius: 12;" +
            "-fx-border-radius: 12; -fx-border-color:#c27ca7ff;"
        );
        card.setEffect(new DropShadow(10, Color.rgb(0, 0, 0, 0.1)));

        // Title
        Label title = new Label("Our Environmental Impact");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        title.setTextFill(Color.web("#000408ff"));
        title.setStyle("-fx-underline: true;");

        // Subtext
        Label desc = new Label("Discover how Online Scrap Collection is dedicated to creating a greener world through our sustainable practices:");
       desc.setWrapText(true);
        desc.setFont(Font.font("Arial", 19));
        desc.setTextFill(Color.web("green"));

        // Info Items
        VBox infoList = new VBox(30);
        infoList.getChildren().addAll(
                makeInfoItem( "♻️ Waste Reduction", "By recycling scrap materials, we significantly reduce landfill waste, minimizing environmental impact."),
                makeInfoItem("🌿 Resource Conservation", "Our recycling efforts conserve precious natural resources like water, energy, and raw materials."),
                makeInfoItem( "⚡ Energy Efficiency", "Recycling consumes less energy than manufacturing from scratch, lowering carbon emissions."),
                makeInfoItem( "🔄 Circular Economy", "We reuse and repurpose materials, contributing to a more resilient and sustainable economy.")
        );

        Label footer = new Label("Partnering with Online Scrap Collection empowers you to make a positive environmental impact.");
        footer.setWrapText(false);
        footer.setFont(Font.font("Arial", 18));
        footer.setTextFill(Color.web("#4CAF50"));

        
        // Add all to card
        Button prvButton1 = new Button("Back");
        prvButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });
        prvButton1.setStyle("-fx-background-color : green");
            prvButton1.setFont(Font.font("bold",20));
            prvButton1.setTextFill(Color.WHITE);
            prvButton1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        card.getChildren().addAll(title, desc, infoList, footer,prvButton1);

        root.getChildren().addAll(imageView, card);

        VBox contain = new VBox(root);
        return contain;
    
    }

    
    

    private HBox makeInfoItem( String heading, String description) {
        

        VBox textBox = new VBox(5);

        Label headingLabel = new Label(heading + ":");
        headingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        headingLabel.setTextFill(Color.web("#2e7d32"));

        Label descLabel = new Label(description);
        descLabel.setFont(Font.font("Arial", 18));
        descLabel.setWrapText(true);
        descLabel.setTextFill(Color.web("#555"));

        textBox.getChildren().addAll(headingLabel, descLabel);

        HBox hbox = new HBox(10, textBox);
        hbox.setAlignment(Pos.TOP_LEFT);
        return hbox;
        

    }
}
