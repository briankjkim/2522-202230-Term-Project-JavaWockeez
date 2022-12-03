package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        inGameMusic();
        Image person_two = new Image("ExplosionSpriteFPS7.gif", true);
        Image background = new Image("BoardTemplate.png", true);

        viewBackground = new ImageView(background);
        viewPersonTwo = new ImageView(person_two);

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

        // Register the key listener here
        scene.setOnKeyPressed(player::processKeyPress);
//        scene.setOnKeyPressed(player::processKeyRelease);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Escape Subject 2522");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
