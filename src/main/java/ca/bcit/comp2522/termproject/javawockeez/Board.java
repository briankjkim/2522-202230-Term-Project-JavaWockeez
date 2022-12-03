package ca.bcit.comp2522.termproject.javawockeez;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
/**
 * Board Class.
 * @author Brian KJ Kim, Wallace Trinh
 * @version Dec 2022
 */
public class Board {
    private static final int BOARD_WIDTH = 510;
    private static final int BOARD_HEIGHT = 700;

    private static final Rectangle GameBoard = new Rectangle();

    public static ImageView backgroundImgView() {
        Image bgImg = new Image("BoardTemplate.png");
        ImageView bgImgView = new ImageView(bgImg);
        bgImgView.setFitHeight(BOARD_HEIGHT);
        bgImgView.setFitWidth(BOARD_WIDTH);
        bgImgView.setCache(true);
        return bgImgView;
    }

    public static Rectangle gameBoardSetUp() {
        GameBoard.setWidth(BOARD_WIDTH);
        GameBoard.setHeight(BOARD_HEIGHT);
        GameBoard.setStroke(Color.TRANSPARENT);
        return GameBoard;
    }

    public static Bounds getBounds() {
        return GameBoard.getBoundsInParent();
    }


}
