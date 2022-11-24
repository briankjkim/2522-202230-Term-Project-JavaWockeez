package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class GameEventHandler {
    private AnchorPane gamePane;
    private double paneHeight;
    private double paneWidth;
    Random random = new Random();

    public GameEventHandler(AnchorPane gamePane, double paneHeight, double paneWidth) {
        this.gamePane = gamePane;
        this.paneHeight = paneHeight;
        this.paneWidth = paneWidth;
    }
}
