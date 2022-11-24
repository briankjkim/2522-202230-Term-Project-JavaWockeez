package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

public class Player {

    /**
     * The movement size in pixels when the player presses a key.
     */
    private static final int MOVEMENT_SIZE = 10;
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

    public void moveUP() {
        this.viewCharacter.setLayoutY(this.viewCharacter.getLayoutY() - MOVEMENT_SIZE);
    }
    public void moveDOWN() {
        this.viewCharacter.setLayoutY(this.viewCharacter.getLayoutY() + MOVEMENT_SIZE);
    }
    public void moveLEFT() {
        this.viewCharacter.setLayoutX(this.viewCharacter.getLayoutX() - MOVEMENT_SIZE);
    }
    public void moveRIGHT() {
        this.viewCharacter.setLayoutX(this.viewCharacter.getLayoutX() + MOVEMENT_SIZE);
    }


}
