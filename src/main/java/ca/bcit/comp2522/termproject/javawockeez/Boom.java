package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boom extends Group {
    public static final int IMAGE_SIZE = 50;
    protected Image entityImage;
    protected ImageView entityImgView;
    int size;
    protected boolean isVisible = false;


    public Boom(final int posX, final int posY) {
        this.size = IMAGE_SIZE;
        entityImage = new Image("ExplosionSprite.gif");
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
