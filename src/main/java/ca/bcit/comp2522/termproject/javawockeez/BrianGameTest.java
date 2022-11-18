package ca.bcit.comp2522.termproject.javawockeez;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Brian Kim's branch for testing application.
 * @author kkjin0330
 * @version 2022.11.17
 */
public class BrianGameTest extends Application {


    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        Image background = new Image("backgroundtest.jpeg", true);
        ImageView viewBackground = new ImageView(background);

        Player currentPlayer = new Player("guy");
        TileBlock blockOne = new TileBlock(TileBlock.TileType.START, "Test");

        Group root = new Group(viewBackground, currentPlayer.viewCharacter, blockOne.imageView);

        final int appWidth = 500;
        final int appHeight = 750;
        Scene scene = new Scene(root, appWidth, appHeight);

        // Register the key listener here
        scene.setOnKeyPressed(currentPlayer::processKeyPress);

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
