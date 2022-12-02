package ca.bcit.comp2522.termproject.javawockeez;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
/**
 * Board Class.
 * @author Brian KJ Kim, Wallace Trinh
 * @version Dec 2022
 */
public class Board extends Rectangle {
    public String name;
    private static final int width = 100;
    private static final int height = 400;
    private Paint boardPaint;

    Board(Paint boardPaint) {
        super(width, height, boardPaint);
        name = "Game Board";
    }
}
