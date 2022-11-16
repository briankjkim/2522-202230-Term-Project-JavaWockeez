package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


/**
 * testing Controls.
 */
public class ControlTest extends Application {

    /**
     * Distance in pixels that the alien moves when a key is pressed.
     */
    public static final int MOVEMENT_SIZE = 15;

    // Contains the image of the alien
    private ImageView viewCharacter;
    private ImageView viewBackground;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
        Image person = new Image("PersonMove2.gif", true);
        Image background = new Image("backgroundtest.jpeg", true);
        viewCharacter = new ImageView(person);
        viewBackground = new ImageView(background);
//        viewBackground = new ImageView(
//                new Image("Board.png", true),
//                BackgroundRepeat,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER,
//                BackgroundSize.DEFAULT);
//        imageViewTwo = new ImageView(background);
//        viewBackground = new BackgroundImage(new BackgroundFill(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        final int personStartCoordinateX = 215;
        final int personStartCoordinateY = 700;
        viewCharacter.setX(personStartCoordinateX);
        viewCharacter.setY(personStartCoordinateY);

        Group root = new Group(viewBackground, viewCharacter);
//        Group rootTwo = new Group(viewBackground);

        final int appWidth = 533;
        final int appHeight = 800;
//        root.setId("background");
        Scene scene = new Scene(root, appWidth, appHeight);
//        scene.getStylesheets().add("/Game.css");

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
            case UP -> viewCharacter.setY(viewCharacter.getY() - MOVEMENT_SIZE);
            case DOWN -> viewCharacter.setY(viewCharacter.getY() + MOVEMENT_SIZE);
            case RIGHT -> viewCharacter.setX(viewCharacter.getX() + MOVEMENT_SIZE);
            case LEFT -> viewCharacter.setX(viewCharacter.getX() - MOVEMENT_SIZE);
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
