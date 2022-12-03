package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.geometry.Insets;
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
 * Main Game Driver.
 * @author Brian KJ Kim, Wallace Trinh
 * @version Dec 2022
 */
public class GameDriver extends Application {
    /**
     * Width of the game window set to 510.
     */
    public static final int appWidth = 510;
    /**
     * Height of the game window set to 700.
     */
    public static final int appHeight = 700;
    private Player player;
    private ImageView viewBackground;
    private ImageView viewPersonTwo;
    /**
     * Audio Player for when the Main menu loads in.
     */
    public void inMenuMusic() {
        String path = "src/main/resources/Audio/MainMenu.wav";
        Media media = new Media(Paths.get(path).toUri().toString());
        AudioClip audioPlayer = new AudioClip(media.getSource());
//        audioPlayer.setCycleCount(AudioClip.INDEFINITE);
        audioPlayer.setVolume(0.2);
        audioPlayer.play();
    }
    /**
     * Audio Player for when the Game loads in.
     */
    public void inGameMusic() {
        String path = "src/main/resources/Audio/InGameMusic.wav";
        Media media = new Media(Paths.get(path).toUri().toString());
        AudioClip audioPlayer = new AudioClip(media.getSource());
        audioPlayer.setCycleCount(AudioClip.INDEFINITE);
        audioPlayer.setVolume(0.35);
        audioPlayer.play();
    }
    /**
     * Launches the JavaFX application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Initial start of the application.
     * @param stage represents the JavaFX container.
     * @throws Exception is unchecked.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Escape Subject 2522");
        stage.setWidth(510);
        stage.setHeight(725);
        stage.setScene(mainMenu(stage));
        stage.show();
    }
    /**
     * The first scene represented as the main menu.
     * @param stage represented as the main menu container.
     * @return main menu scene.
     */
    public Scene mainMenu(Stage stage){// Creating a button in the first scene to be placed at the center
        inMenuMusic();
        Button startButton = new Button();
        startButton.setPrefWidth(150);
        startButton.setPrefHeight(15);
        startButton.setText("Start");

        HBox hbox1 = new HBox(startButton);
        hbox1.setSpacing(5);
        hbox1.setPadding(new Insets(470,250,200,85));

        BorderPane mainMenuPane = new BorderPane();// It is used in order to set it at the center
        mainMenuPane.setCenter(hbox1);
        mainMenuPane.getStylesheets().add("stylesheet.css");

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
     * The main game represented as scene 2.
     * @param stage as the main game container.
     * @return the main game.
     * @throws Exception is unchecked.
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
