package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;


/**
 * testing Controls.
 */
public class ControlTest extends Application {

    /**
     * Distance in pixels that the alien moves when a key is pressed.
     */
    public static final int MOVEMENT_SIZE = 20;

    // Contains the image of the alien
    private ImageView imageView;
    private ImageView viewBackground;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        Image person = new Image("person3.png", true);
        Image background = new Image("Board.png", true);
        imageView = new ImageView(person);
        viewBackground = new ImageView(background);
//        imageViewTwo = new ImageView(background);
//        viewBackground = new BackgroundImage(new BackgroundFill(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        final int personStartCoordinate = 350;
        imageView.setX(personStartCoordinate);
        imageView.setY(personStartCoordinate);

        Group root = new Group(imageView);

        final int appWidth = 500;
        final int appHeight = 800;
        Scene scene = new Scene(root, appWidth, appHeight);

        // Register the key listener here
        scene.setOnKeyPressed(this::processKeyPress);

        primaryStage.setTitle("Escape Subject 2522");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Modifies the position of the image view when an arrow key is pressed.
     *
     * @param event invoked this method
     */
    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            case UP -> imageView.setY(imageView.getY() - MOVEMENT_SIZE);
            case DOWN -> imageView.setY(imageView.getY() + MOVEMENT_SIZE);
            case RIGHT -> imageView.setX(imageView.getX() + MOVEMENT_SIZE);
            case LEFT -> imageView.setX(imageView.getX() - MOVEMENT_SIZE);
            default -> {
            } // Does nothing if it's not an arrow key
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
