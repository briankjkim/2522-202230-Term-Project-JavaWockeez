package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;

public class Player extends Node {

    /**
     * The movement size in pixels when the player presses a key.
     */
    private static final int MOVEMENT_SIZE = 20;
    public String name;
    public ImageView viewCharacter;
    private boolean isAlive;

    public Player() {
        this.name = "Guy";
        this.isAlive = true;
        Image person = new Image("PersonMove2.gif", true);
        viewCharacter = new ImageView(person);

        final int personStartCoordinate = 350;
        viewCharacter.setX(personStartCoordinate);
        viewCharacter.setY(personStartCoordinate);
    }
//    /**
//     * Modifies the position of the image view when an arrow key is pressed.
//     *
//     * @param event invoked this method
//     */
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

}
