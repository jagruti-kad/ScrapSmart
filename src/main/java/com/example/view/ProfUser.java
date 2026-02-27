package com.example.view;
import java.util.Map;
import com.example.controller.ProfileController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfUser {
    Scene page14Scene;
    Stage p14Stage;

    public void setScene(Scene scene) {
        this.page14Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p14Stage = stage;
    }

    public VBox createScene(Runnable back) {
        // Card layout for profile
        VBox profileCard = new VBox();
        profileCard.setPadding(new Insets(40));
        profileCard.setSpacing(20);
        profileCard.setAlignment(Pos.CENTER_LEFT);
        profileCard.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.75);" +
            "-fx-background-radius: 20;" +
            "-fx-border-color: #ddd;" +
            "-fx-border-radius: 20;" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0.3, 0, 5);"
        );

        try {
            Map<String, Object> profile = ProfileController.readPlayer();

            if (profile != null) {
                Text header = new Text("👤 User Profile");
                header.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26));
                header.setFill(Color.web("#1E2F41"));

                Text nameLabel = new Text("👤 Name: " + profile.get("name"));
                 Text emailLabel = new Text("✉️ Email: " + profile.get("email"));
                 Text userLabel = new Text("🆔 Username: " + profile.get("userName"));
                 Text mobileLabel = new Text("📞 Mobile: " + profile.get("mobile"));
                 Text addressLabel = new Text("🏠 Address: " + profile.get("address"));

                for (Text label : new Text[]{nameLabel, emailLabel, userLabel, mobileLabel, addressLabel}) {
                    label.setFont(Font.font("Segoe UI", 18));
                    label.setFill(Color.web("#2c2c2c"));
                }

                profileCard.getChildren().addAll(header, nameLabel, emailLabel, userLabel, mobileLabel, addressLabel);
            } else {
                Text noData = new Text("⚠️ No profile data found.");
                noData.setFont(Font.font("Segoe UI", 16));
                noData.setFill(Color.RED);
                profileCard.getChildren().add(noData);
            }
        } catch (Exception e) {
            Text errorLabel = new Text("❌ Error loading profile: " + e.getMessage());
            errorLabel.setFont(Font.font("Segoe UI", 16));
            errorLabel.setFill(Color.RED);
            profileCard.getChildren().add(errorLabel);
        }

        // Stylish Back Button
        Button button = new Button("⟵ Back");
        button.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
        button.setTextFill(Color.WHITE);
        button.setStyle(
            "-fx-background-color: #4CAF50;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10 25;" +
            "-fx-cursor: hand;"
        );

        // Hover effect
        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-background-color: #45A049;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10 25;" +
            "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
            "-fx-background-color: #4CAF50;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 10 25;" +
            "-fx-cursor: hand;"
        ));

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });

        // Outer container
        VBox container = new VBox(profileCard, button);
        container.setSpacing(50);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(100));
        container.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #6a9c5fff, #ffffff);"
        );

        return container;
    }
}
