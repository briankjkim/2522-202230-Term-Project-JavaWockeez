package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileBlock {

    public enum TileType {
        START, GOAL, OBSTACLE, EXPLOSIVE
    }
    public String name;
    public ImageView imageView;
    public TileType tileType;

    TileBlock(TileType tileType, String tileName) {
        this.tileType = tileType;
        this.name = tileName;
        Image blockImage = new Image("tileblock.png", true);

        final int blockLocationX = 250;
        final int blockLocationY = 250;

        imageView = new ImageView(blockImage);
        imageView.setX(blockLocationX);
        imageView.setY(blockLocationY);
    }
}
