package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import static ca.bcit.comp2522.termproject.javawockeez.WallaceGameTest.appHeight;
import static ca.bcit.comp2522.termproject.javawockeez.WallaceGameTest.appWidth;

public class Player {
    public static final double STARTING_X = 240;
    public static final double STARTING_Y = 600;
    /**
     * The movement size in pixels when the player presses a key.
     */
    public static final int MOVEMENT_SIZE = 20;
    public static final String IMAGE_CHARACTER = "PersonMove2.gif";
    public String name;
    public static ImageView viewCharacter;

    private Player player;
    private static Player singletonPlayer;

    public Player(String name) {
        this.name = name;
        this.viewCharacter = new ImageView (new Image("PersonMove2.gif", true));
//        viewCharacter = new ImageView(person);
        viewCharacter.setX(STARTING_X);
        viewCharacter.setY(STARTING_Y);
//        viewCharacter.setFitHeight(30);
//        viewCharacter.setFitWidth(30);
//        viewCharacter.setSmooth(true);
//        viewCharacter.setPreserveRatio(true);
//        final int personStartCoordinate = 350;
//        viewCharacter.setX(personStartCoordinate);
//        viewCharacter.setY(personStartCoordinate);
    }
    public static Player getInstance() {
        if (singletonPlayer == null) {
            singletonPlayer = new Player(IMAGE_CHARACTER);
        }
        return singletonPlayer;
    }
    public ImageView getViewCharacter() {
        return viewCharacter;
    }

    public static void characterXCoordinate(final double movement){
        if (movement < appWidth - 30 && movement > 0) {
            viewCharacter.setX(movement);
        }
    }
    public static void characterYCoordinate(final double movement){
        if (movement < appHeight - 30 && movement > 0) {
            viewCharacter.setY(movement);
        }
    }

    //    /**
//     * Modifies the position of the image view when an arrow key is pressed.
//     *
//     * @param event invoked this method
//     */
    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            case UP -> Player.characterYCoordinate(Player.viewCharacter.getY() - MOVEMENT_SIZE);
            case DOWN -> Player.characterYCoordinate(Player.viewCharacter.getY() + MOVEMENT_SIZE);
            case RIGHT -> Player.characterXCoordinate(Player.viewCharacter.getX() + MOVEMENT_SIZE);
            case LEFT -> Player.characterXCoordinate(Player.viewCharacter.getX() - MOVEMENT_SIZE);
            default -> {
            } // Does nothing if it's not an arrow key
        }
    }
}
