package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * Brian Kim's branch for testing application.
 * @author kkjin0330
 * @version 2022.11.17
 */
public class GameBoardDriver extends Application {


    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        Image background = new Image("backgroundtest.jpeg", true);
        ImageView viewBackground = new ImageView(background);

        Player currentPlayer = new Player();
        TileBlock blockOne = new TileBlock(TileBlock.TileType.START, "Test");
        Board gameBoard = new Board(Color.GREY);
        gameBoard.setX(150);
        gameBoard.setY(150);
        Group root = new Group(viewBackground, gameBoard, blockOne.imageView, currentPlayer.viewCharacter);

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

