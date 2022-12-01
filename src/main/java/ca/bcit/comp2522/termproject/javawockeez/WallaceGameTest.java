package ca.bcit.comp2522.termproject.javawockeez;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * testing Controls.
 */
public class WallaceGameTest extends Application {

    public static final int appWidth = 510;
    public static final int appHeight = 700;
    private Player player;
    private ImageView viewBackground;
    private ImageView viewPersonTwo;

    /**
     * Displays an image that can be moved using the arrow keys.
     *
     * @param primaryStage a Stage
     */
    public void start(final Stage primaryStage) {

        Image person_two = new Image("ExplosionSpriteFPS7.gif", true);
        Image background = new Image("BoardTemplate.png", true);

        viewBackground = new ImageView(background);
        viewPersonTwo = new ImageView(person_two);

        final int explosionStartCoordinateX = 170;
        final int explosionStartCoordinateY = 261;
        viewPersonTwo.setX(explosionStartCoordinateX);
        viewPersonTwo.setY(explosionStartCoordinateY);

        FadeTransition ft = new FadeTransition(Duration.millis(2000), viewPersonTwo);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        Player player = new Player("subject2522");
        Group root = new Group(viewBackground, Player.viewCharacter, viewPersonTwo);

        Scene scene = new Scene(root, appWidth, appHeight);

        // Register the key listener here
        scene.setOnKeyPressed(player::processKeyPress);
//        scene.setOnKeyPressed(player::processKeyRelease);

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
