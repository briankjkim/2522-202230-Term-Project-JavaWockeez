package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Boom extends Rectangle implements Runnable {
    private static final Random GENERATOR = new Random();
    private static final int MAX_X = 510;
    private static final int MAX_Y = 700;

    private int dy;
    private int dx;
    @Override
    public void run() {

    }
}
