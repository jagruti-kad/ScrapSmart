package com.example.view;

import com.example.controller.ProfileController;
import com.example.controller.ViewController;
import com.example.model.ProfileModel;
import com.example.model.ViewModel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateProf {
    Scene page17Scene,page2Scene,page10Scene,page1Scene,logingScene;
    Stage p17Stage;
    public void setScene(Scene scene){
        this.page17Scene = scene;
    }

    public void setStage(Stage stage){
        this.p17Stage = stage;
    }
    public VBox createScene(Runnable back){
        

        Text name = new Text("Full Name:");
        name.setFont(new Font(15));
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setPrefHeight(30);
        nameField.setFont(Font.font("Arial", 15));

        
        Text email = new Text("Email:");
        email.setFont(new Font(15));
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email id");
        emailField.setPrefHeight(30);
        emailField.setFont(Font.font("Arial", 15));

        Text  user = new Text("Username:");
        user.setFont(new Font(15));
        TextField userField = new TextField();
        userField.setPromptText("Enter your username");
        userField.setPrefHeight(30);
        userField.setFont(Font.font("Arial", 15));
        
        Text mob = new Text("Mob No:");
        mob.setFont(new Font(15));
        TextField mobField = new TextField();
        mobField.setPromptText("Enter your mobile no");
        mobField.setPrefHeight(30);
        mobField.setFont(Font.font("Arial", 15));

        Text add = new Text("Address");
        add.setFont(new Font(15));
        TextField addField = new TextField();
        addField.setPromptText("Enter your address");
        addField.setPrefHeight(30);
        addField.setFont(Font.font("Arial", 15));
        
        DatePicker pickupDate = new DatePicker();
        pickupDate.setStyle("-fx-font-size: 16px;");
        Text birth= new Text("Date of Birth");
         birth.setFont(new Font(15));


ComboBox<String> loginOptions = new ComboBox<>();
    loginOptions.getItems().addAll("User_Login", "Collector_Login");
    loginOptions.setPromptText("Select Login Type");
    loginOptions.setPrefHeight(30);
    loginOptions.setStyle("-fx-font-size: 14px;");

        Button button = new Button("Create Account");
        button.setStyle("-fx-background-color : green");
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font("bold",15));


        button.setOnAction(e -> {
        String selected = loginOptions.getValue();
       // if (selected == null) return;

        switch (selected) {
            case "User_Login":{
                ProfileModel pf = new ProfileModel(
                    nameField.getText(),
                    emailField.getText(),
                    userField.getText(),
                    mobField.getText(),
                    addField.getText()
                );
                try {
                    ProfileController.storeProfile(
                        pf.getName(), pf.getEmail(), pf.getUserName(),
                        pf.getMobile(), pf.getAddress()
                    );
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            }

            case "Collector_Login":{
                ViewModel vm = new ViewModel(
                    nameField.getText(),
                    emailField.getText(),
                    userField.getText(),
                    mobField.getText(),
                    addField.getText()
                );
                try {
                    ViewController.storeView(
                        vm.getName(), vm.getEmail(), vm.getUserName(),
                        vm.getMobile(), vm.getAddress()
                    );
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;      
        }}
            LoginPage lg=new LoginPage();
            lg.setStage(p17Stage);
            logingScene=new Scene(lg.createScene(this::handleBack),1550,800);
            lg.setScene(page10Scene);
            p17Stage.setScene(logingScene);
           // back.run();
        });
        

        VBox vbox = new VBox(12,
            name, nameField,
            email, emailField,
            user, userField,
            mob, mobField,
            add, addField,
            birth, pickupDate,loginOptions,
              button
        );

        VBox card = new VBox(vbox);
    card.setPadding(new Insets(40));
    card.setStyle(
        "-fx-background-color: #91b39bff; "
        //"-fx-border-color: darkgreen;" 
       + "-fx-border-radius: 15;" +
        "-fx-background-radius: 15;" +
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 5);"
    );
        card.setStyle("-fx-background-color: #91b39bff; -fx-padding: 30; -fx-border-color: green; -fx-border-width: 2;"+"-fx-border-radius: 20;"+ "-fx-background-radius: 20;");
        card.setMaxWidth(500);
    card.setStyle(card.getStyle() + "-fx-alignment: center;");

    // Root VBox (centers the card)
    VBox root = new VBox(card);
    root.setAlignment(javafx.geometry.Pos.CENTER);
    root.setPadding(new Insets(70));
    // root.setStyle(
    // "-fx-background-image: url('/assets/images/blurimg.jpg');"+"-fx-background-size: cover;" );
    root.setStyle(
        "-fx-background-color: linear-gradient(to bottom right, #e8f5e8,rgb(192, 235, 193),rgb(169, 240, 171));" +
        "-fx-background-size: cover;"
    );
    return root;
    }

    public void handleBack(){
        p17Stage.setScene(page10Scene);
    }

}

