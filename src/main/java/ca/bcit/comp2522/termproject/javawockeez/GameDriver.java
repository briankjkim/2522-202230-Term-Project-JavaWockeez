package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.nio.file.Paths;

/**
 * Main Game Driver
 * @author Brian KJ Kim, Wallace Trinh
 * @version Dec 2022
 */
public class GameDriver extends Application {
    public static final int appWidth = 510;
    public static final int appHeight = 700;
    private Player player;
    private ImageView viewBackground;
    private ImageView viewPersonTwo;
    /**
     * Audio Player for when the Game loads in.
     */
    public void inGameMusic() {
        String path = "src/main/resources/Audio/InGameMusic.wav";
        Media media = new Media(Paths.get(path).toUri().toString());
        AudioClip audioPlayer = new AudioClip(media.getSource());
        audioPlayer.setCycleCount(AudioClip.INDEFINITE);
        audioPlayer.setVolume(0.25);
        audioPlayer.play();
    }


    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Escape Subject 2522");
        stage.setWidth(510);
        stage.setHeight(725);
        stage.setScene(mainMenu(stage));
        stage.show();
    }

    public Scene mainMenu(Stage stage){// Creating a button in the first scene to be placed at the center
        Button startButton = new Button();
        startButton.setPrefWidth(100);
        startButton.setPrefHeight(20);

        startButton.setText("Start");

        HBox hbox1 = new HBox(startButton);
        hbox1.setSpacing(10);

        hbox1.setAlignment(Pos.CENTER);

        BorderPane mainMenuPane = new BorderPane();// It is used in order to set it at the center
        mainMenuPane.setCenter(hbox1);

        startButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                stage.setScene(inGame(stage));
            } catch (Exception e) {
                //ignore
            }
            stage.show();
        });

        return new Scene(mainMenuPane);
    }
    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public Scene inGame(final Stage stage) throws Exception {
        inGameMusic();
        Image person_two = new Image("ExplosionSpriteFPS7.gif", true);
        Image background = new Image("BoardTemplate.png", true);

        viewBackground = new ImageView(background);
        viewPersonTwo = new ImageView(person_two);

        BorderPane gamePane = new BorderPane();

        final int explosionStartCoordinateX = 170;
        final int explosionStartCoordinateY = 261;
        viewPersonTwo.setX(explosionStartCoordinateX);
        viewPersonTwo.setY(explosionStartCoordinateY);
        Player player = new Player("subject2522");
        Group root = new Group(viewBackground, Player.viewCharacter, viewPersonTwo);

        Boom boom2 = new Boom(100, 200) {
        };

        Boom boom3 = new Boom(400, 500) {
        };

        root.getChildren().addAll(boom2, boom3);

        Scene scene = new Scene(root, appWidth, appHeight);

        scene.setOnKeyPressed(player::processKeyPress);
        stage.setResizable(false);
        stage.setTitle("Escape Subject 2522");
        stage.setScene(scene);
        stage.show();
        return new Scene(scene.getRoot());
    }

}
