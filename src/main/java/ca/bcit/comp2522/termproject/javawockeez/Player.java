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
    private double x;
    private double y;

    private double velX = 0;
    private double velY = 0;

    private Player player;

    public Player(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        Image person = new Image("PersonMove2.gif", true);
        viewCharacter = new ImageView(person);

        final int personStartCoordinate = 350;
        viewCharacter.setX(personStartCoordinate);
        viewCharacter.setY(personStartCoordinate);
    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    //    /**
//     * Modifies the position of the image view when an arrow key is pressed.
//     *
//     * @param event invoked this method
//     */
    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            if (event.getCode() == KeyCode.UP) {
                player.setVelY(MOVEMENT_SIZE);
            }
            if (event.getCode() == KeyCode.DOWN) {
                player.setVelY(MOVEMENT_SIZE);
            }
            if (event.getCode() == KeyCode.RIGHT) {
                player.setVelX(MOVEMENT_SIZE);
            } else if (event.getCode() == KeyCode.LEFT) {
                player.setVelX(MOVEMENT_SIZE);
            }
        }
//        switch (event.getCode()) {
//            case UP -> viewCharacter.setY(viewCharacter.getY() - MOVEMENT_SIZE);
//            case DOWN -> viewCharacter.setY(viewCharacter.getY() + MOVEMENT_SIZE);
//            case RIGHT -> viewCharacter.setX(viewCharacter.getX() + MOVEMENT_SIZE);
//            case LEFT -> viewCharacter.setX(viewCharacter.getX() - MOVEMENT_SIZE);
//            default -> {
//            } // Does nothing if it's not an arrow key
    }

    public void processKeyRelease(final KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            player.setVelY(0);
        }
        if (event.getCode() == KeyCode.DOWN) {
            player.setVelY(0);
        }
        if (event.getCode() == KeyCode.RIGHT) {
            player.setVelX(0);
        } else if (event.getCode() == KeyCode.LEFT) {
            player.setVelX(0);
        }

    }
}