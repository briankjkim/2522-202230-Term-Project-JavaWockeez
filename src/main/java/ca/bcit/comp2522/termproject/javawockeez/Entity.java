package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public abstract class Entity extends Group {
    public static final int IMAGE_SIZE = 50;
    protected Image entityImage;
    protected ImageView entityImgView;
    int size;
    protected boolean isVisible = false;

    public Entity() {
        this("PersonMove2.gif");
    }

    public Entity(final String entityImage) {
        this(0, 0, entityImage);
    }

    public Entity(final int posX, final int posY, final String entityImage) {
        this(posX, posY, IMAGE_SIZE, entityImage);
    }

    public Entity(final int posX, final int posY, final int imgSize, final String imgName) {
        this.size = imgSize;
        entityImage = new Image(Objects.requireNonNull(WallaceGameTest.class.getResource(imgName)).toExternalForm());
        entityImgView = new ImageView(entityImage);
        entityImgView.setFitWidth(this.size);
        entityImgView.setPreserveRatio(true);
        entityImgView.setSmooth(true);
        entityImgView.setCache(true);
        this.getChildren().add(entityImgView);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    public int getCenterX() {
        return (int) (this.getTranslateX() + (size / 2));
    }

    public int getCenterY() {
        return (int) (this.getTranslateY() + (size / 2));
    }
}
