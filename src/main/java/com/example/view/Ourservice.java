package com.example.view;

import java.io.InputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ourservice {
    Scene page6Scene;
    Stage p6Stage;

    public void setScene(Scene scene) {
        this.page6Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p6Stage = stage;
    }

    public VBox createScene(Runnable back) {
        Text heading = new Text("Our Service");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        heading.setFill(Color.web("#2E8B57")); // Dark green text for contrast on light background
        heading.setUnderline(true);
        
        // Dark green shadow for better visibility
        DropShadow headingShadow = new DropShadow();
        headingShadow.setColor(Color.web("#1F5F1F"));
        headingShadow.setOffsetX(2);
        headingShadow.setOffsetY(2);
        headingShadow.setRadius(5);
        heading.setEffect(headingShadow);

        VBox headingBox = new VBox(heading);
        headingBox.setAlignment(Pos.CENTER);
        headingBox.setPadding(new Insets(20, 0, 20, 0));

        VBox card1 = createCard("/assets/images/recycle.jpg","Waste Collection\n" ,
                        "Efficient and timely waste collection services at your doorstep.\n" );
        VBox card2 = createCard("/assets/images/tree.jpg","Recycling Services\n" ,
                        "Convert your waste into reusable materials through our recycling program");
        VBox card3 = createCard("/assets/images/leaf.jpg","Environmental Awareness\n" ,
                        "Visit the location with tools, weigh scrap items on-site, and enter the weight in the app to calculate total value.\n"  );

        HBox hb = new HBox(30,card1,card2,card3);
        hb.setAlignment(Pos.TOP_CENTER);
        hb.setPadding(new Insets(40));

        Button prvButton1 = new Button("Back");
        prvButton1.setStyle("-fx-background-color: #2E8B57;" + // Sea green button
                           "-fx-text-fill: WHITE;" +
                           "-fx-font-size: 20px;" +
                           "-fx-font-weight: bold;" +
                           "-fx-padding: 12 25 12 25;" +
                           "-fx-border-radius: 8;" +
                           "-fx-background-radius: 8;" +
                           "-fx-effect: dropshadow(gaussian, #1F5F1F, 5, 0, 0, 3);" +
                           "-fx-cursor: hand;");
        
        // Button hover effect
        prvButton1.setOnMouseEntered(e -> {
            prvButton1.setStyle("-fx-background-color: #228B22;" +
                               "-fx-text-fill: WHITE;" +
                               "-fx-font-size: 20px;" +
                               "-fx-font-weight: bold;" +
                               "-fx-padding: 12 25 12 25;" +
                               "-fx-border-radius: 8;" +
                               "-fx-background-radius: 8;" +
                               "-fx-effect: dropshadow(gaussian, #1F5F1F, 8, 0, 0, 5);" +
                               "-fx-cursor: hand;");
        });
        
        prvButton1.setOnMouseExited(e -> {
            prvButton1.setStyle("-fx-background-color: #2E8B57;" +
                               "-fx-text-fill: WHITE;" +
                               "-fx-font-size: 20px;" +
                               "-fx-font-weight: bold;" +
                               "-fx-padding: 12 25 12 25;" +
                               "-fx-border-radius: 8;" +
                               "-fx-background-radius: 8;" +
                               "-fx-effect: dropshadow(gaussian, #1F5F1F, 5, 0, 0, 3);" +
                               "-fx-cursor: hand;");
        });
        
        prvButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });

        VBox root = new VBox(headingBox,hb,prvButton1);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(40));
        
        // Beautiful light green gradient background
        root.setStyle("-fx-background-color: linear-gradient(to bottom, " +
                     "#F0FFF0 0%, #E8F5E8 25%, #D8F3DC 50%, #C7F0C7 75%, #B7E4C7 100%);");

        return root;
    }

    private VBox createCard(String photopath, String title, String description){
        InputStream is = getClass().getResourceAsStream(photopath);
        if (is == null) {
            throw new RuntimeException("Resource not found: " + photopath);
        }
        
        Image image = new Image(is);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);
        
        // Enhanced shadow for image
        DropShadow imageShadow = new DropShadow();
        imageShadow.setColor(Color.web("#2E8B57", 0.3));
        imageShadow.setOffsetX(0);
        imageShadow.setOffsetY(3);
        imageShadow.setRadius(8);
        imageView.setEffect(imageShadow);

        Text titleText = new Text(title);
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        titleText.setFill(Color.web("#2E8B57")); // Dark green for good contrast

        Text descText = new Text(description);
        descText.setFont(Font.font("Arial", 15));
        descText.setWrappingWidth(200);
        descText.setFill(Color.web("#1F5F1F")); // Darker green for readability

        VBox card = new VBox(10,imageView,titleText, descText);
        card.setPadding(new Insets(20));
        
        // Enhanced card styling with light green theme
        card.setStyle("-fx-background-color: linear-gradient(to bottom, #FFFFFF, #F8FFF8);" + 
                     "-fx-border-color: #52B788;" + 
                     "-fx-border-width: 2;" +
                     "-fx-border-radius: 10;" + 
                     "-fx-background-radius: 10;" +
                     "-fx-effect: dropshadow(gaussian, rgba(82,183,136,0.3), 8, 0, 0, 4);");
        
        card.setPrefSize(300, 350);
        card.setAlignment(Pos.TOP_CENTER);
        
        // Card hover effect
        card.setOnMouseEntered(e -> {
            card.setStyle("-fx-background-color: linear-gradient(to bottom, #F8FFF8, #F0FFF0);" +
                         "-fx-border-color: #40916C;" +
                         "-fx-border-width: 3;" +
                         "-fx-border-radius: 10;" +
                         "-fx-background-radius: 10;" +
                         "-fx-effect: dropshadow(gaussian, rgba(64,145,108,0.4), 12, 0, 0, 6);");
        });
        
        card.setOnMouseExited(e -> {
            card.setStyle("-fx-background-color: linear-gradient(to bottom, #FFFFFF, #F8FFF8);" +
                         "-fx-border-color: #52B788;" +
                         "-fx-border-width: 2;" +
                         "-fx-border-radius: 10;" +
                         "-fx-background-radius: 10;" +
                         "-fx-effect: dropshadow(gaussian, rgba(82,183,136,0.3), 8, 0, 0, 4);");
        });

        return card;            
    }
}