package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import static ca.bcit.comp2522.termproject.javawockeez.WallaceGameTest.appHeight;
import static ca.bcit.comp2522.termproject.javawockeez.WallaceGameTest.appWidth;

public class Player {
    /**
     * Starting X coordinate of the character.
     */
    public static final double STARTING_X = 240;
    /**
     * Starting Y coordinate of the character.
     */
    public static final double STARTING_Y = 600;
    /**
     * The movement size in pixels when the player presses a key.
     */
    public static final int MOVEMENT_SIZE = 20;
    /**
     * The image of the character model as a string.
     */
    public static final String IMAGE_CHARACTER = "PersonMove2.gif";
    /**
     * The name of the Player stored as string.
     */
    public String name;
    /**
     * The character model image to be controlled by the user.
     */
    public static ImageView viewCharacter;
    private static int LIFECOUNTER = 3;
    private Player player;
//    private static Player singletonPlayer;

    /**
     * The constructor of the Player class.
     * @param name represented as a string.
     */
    public Player(String name) {
        this.name = name;
        viewCharacter = new ImageView (new Image("PersonMove2.gif", true));
//        viewCharacter = new ImageView(person);
        viewCharacter.setX(STARTING_X); // Starting X coordinate of the character.
        viewCharacter.setY(STARTING_Y); // Starting Y coordinate of the character.
//        viewCharacter.setFitHeight(30); // Adjust the height of the character size.
//        viewCharacter.setFitWidth(30); // Adjust the width of the character size.
        viewCharacter.setSmooth(true);
        viewCharacter.setPreserveRatio(true);
    }
//    public static Player getInstance() {
//        if (singletonPlayer == null) {
//            singletonPlayer = new Player(IMAGE_CHARACTER);
//        }
//        return singletonPlayer;
//    }

    /**
     * The access modifier for the viewCharacter.
     * @return viewCharacter.
     */
    public ImageView getViewCharacter() {
        return viewCharacter;
    }
    /**
     * The character's X coordinate boundary to restrict the character from leaving the application's width.
     * @param movement represented as a double.
     */
    public static void characterXCoordinate(final double movement){
        if (movement < appWidth - 30 && movement > -30) {
            viewCharacter.setX(movement);
        }
    }
    /**
     * The character's Y coordinate boundary to restrict the character from leaving the application's height.
     * @param movement represented as a double.
     */
    public static void characterYCoordinate(final double movement){
        if (movement < appHeight - 50 && movement > -20) {
            viewCharacter.setY(movement);
        }
    }
    /**
     * Modifies the position of the image view when an arrow key is pressed.
     * @param event invoked this method
     */
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
