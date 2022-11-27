package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    boolean goNorth, goSouth, goEast, goWest;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        Image background = new Image("backgroundtest.jpeg", true);
        ImageView viewBackground = new ImageView(background);

        currentPlayer = new Player();
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

    private void moveGuyBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = currentPlayer.getBoundsInLocal().getWidth()  / 2;
        final double cy = currentPlayer.getBoundsInLocal().getHeight() / 2;

        double x = cx + currentPlayer.getLayoutX() + dx;
        double y = cy + currentPlayer.getLayoutY() + dy;

        moveGuyTo(x, y);
    }

    private void moveGuyTo(double x, double y) {
        final double cx = currentPlayer.getBoundsInLocal().getWidth()  / 2;
        final double cy = currentPlayer.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= APP_WIDTH &&
                y - cy >= 0 &&
                y + cy <= APP_HEIGHT) {
            currentPlayer.relocate(x - cx, y - cy);
        }
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

