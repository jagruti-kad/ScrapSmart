

package com.example.view;

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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AboutUs {
    Scene page20Scene;
    Stage p20Stage;

    public void setScene(Scene scene) {
        this.page20Scene = scene;
    }

    public void setStage(Stage stage) {
        this.p20Stage = stage;
    }

    public BorderPane createScene(Runnable back) {

        // === BACK BUTTON ===
        Button backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
        });
        backButton.setStyle("-fx-background-color: green");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        backButton.setTextFill(Color.WHITE);

        HBox topBar = new HBox(backButton);
        topBar.setAlignment(Pos.TOP_LEFT);
        topBar.setPadding(new Insets(20));
        topBar.setStyle("-fx-background-color: transparent;");

        // === SECTION 1: Group ===
        Text groupName = new Text("EcoCoder");
        groupName.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 44));
        groupName.setFill(Color.web("#2E7D32"));

        Text projectName = new Text("ScrapSmart");
        projectName.setFont(Font.font("Verdana", FontWeight.BOLD, 32));
        projectName.setFill(Color.web("#388E3C"));

        Label groupDescription = new Label(
                "SmartScrap is an eco-friendly scrap management project developed by EcoCoder. "
                        + "It aims to simplify scrap collection and promote sustainable practices."
        );
        groupDescription.setFont(Font.font(18));
        groupDescription.setWrapText(true);
        groupDescription.setMaxWidth(1000);

        VBox groupSection = new VBox(12, groupName, projectName, groupDescription);
        groupSection.setAlignment(Pos.CENTER);
        groupSection.setPadding(new Insets(40));
        groupSection.setStyle(
                "-fx-background-color: #E8F5E9; "
                        + "-fx-background-radius: 12; "
                        + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 12, 0, 0, 6);"
        );

        // === SECTION 2: Class ===
        Label classTitle = new Label("Core2Web");
        classTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        classTitle.setTextFill(Color.web("#2E7D32"));

        ImageView classLogo = new ImageView(new Image("/assets/images/icon_img.jpg"));
        classLogo.setFitWidth(120);
        classLogo.setFitHeight(120);

        VBox classLogoBox = new VBox(10, classTitle, classLogo);
        classLogoBox.setAlignment(Pos.CENTER);

        Label classInfo = new Label(
                "I’m currently learning and growing with Core2Web, a place where coding truly becomes clear and enjoyable. "
                        + "The mentors here are highly experienced and explain every concept — from basics to advanced — with real-world examples "
                        + "and practical sessions that build confidence. Whether it’s Data Structures, Algorithms, Java, Web Development, or problem-solving, "
                        + "Core2Web provides structured guidance, hands-on coding, and regular assessments that keep us on track. "
                        + "The learning environment is super supportive, perfect for both beginners and those aiming to sharpen their skills for placements or projects. "
                        + "Being part of Core2Web is not just about learning to code — it’s about transforming into a confident developer."
        );
        classInfo.setFont(Font.font(16));
        classInfo.setWrapText(true);
        classInfo.setMaxWidth(800);

        HBox classSection = new HBox(30, classLogoBox, classInfo);
        classSection.setAlignment(Pos.CENTER_LEFT);
        classSection.setPadding(new Insets(40));
        classSection.setStyle(
                "-fx-background-color: #FFFFFF; "
                        + "-fx-background-radius: 12; "
                        + "-fx-border-color: #A5D6A7; "
                        + "-fx-border-radius: 12; "
                        + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 12, 0, 0, 6);"
        );

        // === SECTION 3: Teacher ===
        ImageView teacherImage = new ImageView(new Image("/assets/images/shashisir_img.jpg"));
        teacherImage.setFitWidth(120);
        teacherImage.setFitHeight(120);

        Label teacherName = new Label("Shashi Sir");
        teacherName.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        teacherName.setAlignment(Pos.CENTER);

        VBox teacherImageBox = new VBox(8, teacherImage, teacherName);
        teacherImageBox.setAlignment(Pos.CENTER);

        Label teacherInfo = new Label(
                "Shashi Sir doesn’t just teach — he mentors. His support helps build a strong foundation in core technical concepts, "
                        + "shaping not only better coders but more confident individuals. He is undoubtedly a key pillar behind Core2Web’s success. "
                        + "Each lesson and every interaction reflect the wisdom of passionate teachers, the guidance of inspiring mentors, "
                        + "and the encouragement of a truly supportive community."
        );
        teacherInfo.setFont(Font.font(16));
        teacherInfo.setWrapText(true);
        teacherInfo.setMaxWidth(800);

        HBox teacherSection = new HBox(30, teacherImageBox, teacherInfo);
        teacherSection.setAlignment(Pos.CENTER_LEFT);
        teacherSection.setPadding(new Insets(40));
        teacherSection.setStyle(
                "-fx-background-color: #FFFFFF; "
                        + "-fx-background-radius: 12; "
                        + "-fx-border-color: #A5D6A7; "
                        + "-fx-border-radius: 12; "
                        + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 12, 0, 0, 6);"
        );

        // === SECTION 4: Roles ===
        Text coordinatorHeading = new Text("Coordinator:");
        coordinatorHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Label coordinatorNames = new Label("Shivkumar Tengse, Subhodh Yelgandhrwar");

        Text subTeacherHeading = new Text("theamd by");
        subTeacherHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Label subTeacherNames = new Label("Sachin Patil Sir, Pramod Bansode sir");

        Text mentorHeading = new Text("Team Leader");
        mentorHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Label mentorNames = new Label("Monika Bhosale");

        for (Label lbl : new Label[]{coordinatorNames, subTeacherNames, mentorNames}) {
            lbl.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        }

        VBox rolesSection = new VBox(15,
                coordinatorHeading, coordinatorNames,
                subTeacherHeading, subTeacherNames,
                mentorHeading, mentorNames
        );
        rolesSection.setAlignment(Pos.CENTER);
        rolesSection.setPadding(new Insets(30));
        rolesSection.setStyle(
                "-fx-background-color: #E8F5E9; "
                        + "-fx-background-radius: 12; "
                        + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 12, 0, 0, 6);"
        );

        // === SECTION 5: Members ===
        Text membersHeading = new Text("Group Members");
        membersHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        membersHeading.setFill(Color.web("#2E7D32"));

        VBox member1 = createMemberBox("/assets/images/shr.jpg", "Shraddha Jadhav", false);
        VBox member2 = createMemberBox("/assets/images/jagruti_img.jpg", "Jagruti Kad", true);

        HBox membersRow = new HBox(200, member2, member1);
        membersRow.setAlignment(Pos.CENTER);
        membersRow.setMaxHeight(600);
        membersRow.setMaxWidth(800);


        VBox membersSection = new VBox(20, membersHeading, membersRow);
        membersSection.setAlignment(Pos.CENTER);
        membersSection.setPadding(new Insets(30));
        membersSection.setStyle(
                "-fx-background-color: #FFFFFF; "
                        + "-fx-background-radius: 12; "
                        + "-fx-border-color: #A5D6A7; "
                        + "-fx-border-radius: 12; "
                        + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 12, 0, 0, 6);"
        );

        // === MAIN CONTENT ===
        VBox content = new VBox(40, groupSection, classSection, teacherSection, rolesSection, membersSection);
        content.setAlignment(Pos.TOP_CENTER);
        content.setPadding(new Insets(50));
        content.setMaxWidth(1000);

        HBox centeredWrapper = new HBox(content);
        centeredWrapper.setAlignment(Pos.TOP_CENTER);

        ScrollPane scrollPane = new ScrollPane(centeredWrapper);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #F1F8E9;");
        scrollPane.setPrefViewportWidth(1550);
        scrollPane.setPrefViewportHeight(800);

        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setCenter(scrollPane);

        return root;
    }

    private VBox createMemberBox(String imagePath, String memberName, boolean isLeader) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(false);

        Label nameLabel = new Label(memberName);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        nameLabel.setAlignment(Pos.CENTER);

        Label leaderLabel = null;
        if (isLeader) {
            leaderLabel = new Label("(Group Leader)");
            leaderLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
            leaderLabel.setTextFill(Color.DARKGREEN);
            leaderLabel.setAlignment(Pos.CENTER);
        }

        VBox box;
        if (leaderLabel != null) {
            box = new VBox(8, imageView, nameLabel, leaderLabel);
        } else {
            box = new VBox(8, imageView, nameLabel);
        }

        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(15));
        box.setStyle(
                "-fx-background-color: #E8F5E9; "
                        + "-fx-background-radius: 12; "
                        + "-fx-border-color: #A5D6A7; "
                        + "-fx-border-radius: 12;"
        );
        return box;
    }
}
