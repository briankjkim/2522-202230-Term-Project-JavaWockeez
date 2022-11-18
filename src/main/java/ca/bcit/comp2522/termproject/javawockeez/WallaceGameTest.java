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

    private Player player;
    private ImageView viewBackground;
    private ImageView viewPersonTwo;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {

        Image person_two = new Image("boomboom2.gif", true);
        Image background = new Image("backgroundtest.jpeg", true);

        viewBackground = new ImageView(background);
        viewPersonTwo = new ImageView(person_two);

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

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
