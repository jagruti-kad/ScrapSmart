package com.example.utils;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NavButton {

    public static Button createNavButton(String text) {
        Button btn = new Button(text);
        btn.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
        btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #555; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #555;"));
        
        return btn;
    }
}
