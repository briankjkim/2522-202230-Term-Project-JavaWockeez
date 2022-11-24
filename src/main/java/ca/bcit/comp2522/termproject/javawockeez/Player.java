package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.shape.MoveTo;

public class Player {

    /**
     * The movement size in pixels when the player presses a key.
     */
    public static final int MOVEMENT_SIZE = 20;
    public String name;
    public ImageView viewCharacter;
//    private double x;
//    private double y;
//
//    private double velX = 0;
//    private double velY = 0;

    private Player player;

    public Player(String name) {
        this.name = name;
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


