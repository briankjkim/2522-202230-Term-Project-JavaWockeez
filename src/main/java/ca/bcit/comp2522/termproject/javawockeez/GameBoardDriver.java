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
import javafx.stage.Stage;


/**
 * Sprint 2 Application Test
 * @author kkjin0330
 * @version 2022.11.17
 */
public class GameBoardDriver extends Application {

    private static final double APP_WIDTH = 510;
    private static final double APP_HEIGHT = 700;
    private Player currentPlayer;
    private ImageView explosion;
    private ImageView backgroundBoard;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        Image explosionImg = new Image("ExplosionSpriteFPS7.gif", true);
        Image backgroundImg = new Image("BoardTemplate.png", true);

        explosion = new ImageView(explosionImg);
        backgroundBoard = new ImageView(backgroundImg);
        currentPlayer = new Player();

        TileBlock blockOne = new TileBlock(TileBlock.TileType.START, "Test");

        final int explosionStartCoordinateX = 170;
        final int explosionStartCoordinateY = 261;
        explosion.setX(explosionStartCoordinateX);
        explosion.setY(explosionStartCoordinateY);

        Group root = new Group(backgroundBoard, blockOne, currentPlayer.viewCharacter, explosion);

        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> currentPlayer.goNorth = true;
                case DOWN -> currentPlayer.goSouth = true;
                case LEFT -> currentPlayer.goWest = true;
                case RIGHT -> currentPlayer.goEast = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP -> currentPlayer.goNorth = false;
                case DOWN -> currentPlayer.goSouth = false;
                case LEFT -> currentPlayer.goWest = false;
                case RIGHT -> currentPlayer.goEast = false;
            }
        });

        primaryStage.setTitle("Escape Subject 2522");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (currentPlayer.goNorth) currentPlayer.dy -= 1;
                if (currentPlayer.goSouth) currentPlayer.dy += 1;
                if (currentPlayer.goEast)  currentPlayer.dx += 1;
                if (currentPlayer.goWest)  currentPlayer.dx -= 1;

                currentPlayer.moveGuyBy(currentPlayer.dx, currentPlayer.dy);
            }
        };
        timer.start();
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

