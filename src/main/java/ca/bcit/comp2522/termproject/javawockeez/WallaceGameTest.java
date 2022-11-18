package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * testing Controls.
 */
public class WallaceGameTest extends Application {

//    /**
//     * Distance in pixels that the alien moves when a key is pressed.
//     */
//    public static final int MOVEMENT_SIZE = 20;

    // Contains the image of the person, background

    private Player player;
//    private ImageView viewCharacter;
    private ImageView viewBackground;
    private ImageView viewPersonTwo;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {
//        Image person = new Image("PersonMove2.gif", true);
        Image person_two = new Image("boomboom2.gif", true);
        Image background = new Image("backgroundtest.jpeg", true);
//        viewCharacter = new ImageView(person);
        viewBackground = new ImageView(background);
        viewPersonTwo = new ImageView(person_two);

//        final int personStartCoordinate = 350;
//        viewCharacter.setX(personStartCoordinate);
//        viewCharacter.setY(personStartCoordinate);
        Player player = new Player("guy");
        Group root = new Group(viewBackground, player.viewCharacter, viewPersonTwo);

        final int appWidth = 500;
        final int appHeight = 800;
        Scene scene = new Scene(root, appWidth, appHeight);

        // Register the key listener here
        scene.setOnKeyPressed(player::processKeyPress);

        primaryStage.setTitle("Escape Subject 2522");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void controls(String[] args) {

    }
//    /**
//     * Modifies the position of the image view when an arrow key is pressed.
//     *
//     * @param event invoked this method
//     */
//    public void processKeyPress(final KeyEvent event) {
//        switch (event.getCode()) {
//            case UP -> viewCharacter.setY(viewCharacter.getY() - MOVEMENT_SIZE);
//            case DOWN -> viewCharacter.setY(viewCharacter.getY() + MOVEMENT_SIZE);
//            case RIGHT -> viewCharacter.setX(viewCharacter.getX() + MOVEMENT_SIZE);
//            case LEFT -> viewCharacter.setX(viewCharacter.getX() - MOVEMENT_SIZE);
//            default -> {
//            } // Does nothing if it's not an arrow key
//        }
//    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
