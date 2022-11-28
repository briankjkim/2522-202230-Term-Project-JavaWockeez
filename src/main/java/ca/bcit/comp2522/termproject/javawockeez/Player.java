package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;

public class Player extends Node {
    private static final double APP_WIDTH = 510;
    private static final double APP_HEIGHT = 700;
    public double dy;
    public double dx;
    public String name;
    public ImageView viewCharacter;
    private boolean isAlive;
    boolean goNorth, goSouth, goEast, goWest;


    public Player() {
        this.name = "Guy";
        this.isAlive = true;
        Image person = new Image("PersonMove2.gif", true);
        viewCharacter = new ImageView(person);

        final int personStartCoordinate = 350;
        viewCharacter.setX(personStartCoordinate);
        viewCharacter.setY(personStartCoordinate);
    }

    private void moveGuyTo(double x, double y) {
        final double cx = this.getBoundsInLocal().getWidth()  / 2;
        final double cy = this.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= APP_WIDTH &&
                y - cy >= 0 &&
                y + cy <= APP_HEIGHT) {
            this.relocate(x - cx, y - cy);
        }
    }

    void moveGuyBy(double dx, double dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = this.getBoundsInLocal().getWidth()  / 2;
        final double cy = this.getBoundsInLocal().getHeight() / 2;

        double x = cx + this.getLayoutX() + dx;
        double y = cy + this.getLayoutY() + dy;

        moveGuyTo(x, y);
    }


}
