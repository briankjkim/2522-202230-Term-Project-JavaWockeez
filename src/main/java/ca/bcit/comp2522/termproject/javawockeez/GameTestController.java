//package ca.bcit.comp2522.termproject.javawockeez;
//
//import javafx.animation.AnimationTimer;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.AnchorPane;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class GameTestController implements Initializable {
//    AnimationTimer gameLoop;
//
//    @FXML
//    private ImageView player;
//
//    @FXML
//    private AnchorPane scene;
//    @FXML
//    private Canvas canvas;
//
//    private double yDelta = 0.05;
//    private double gameTime = 0;
//
//    private Player playerComponent;
//    private GameEventHandler gameEventHandler;
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        playerComponent = new Player();
//        player = playerComponent.viewCharacter;
//
//        double paneHeight = 600;
//        double paneWidth = 400;
//
//        gameEventHandler = new GameEventHandler(scene, paneHeight, paneWidth);
//
//
//        gameLoop = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                update();
//            }
//        };
//        gameLoop.start();
//    }
//
//    /**
//     * Modifies the position of the image view when an arrow key is pressed.
//     *
//     * @param event invoked this method
//     */
//    public void processKeyPress(final KeyEvent event) {
//        switch (event.getCode()) {
//            case UP -> playerComponent.moveUP();
//            case DOWN -> playerComponent.moveDOWN();
//            case RIGHT -> playerComponent.moveRIGHT();
//            case LEFT -> playerComponent.moveLEFT();
//            default -> {
//            } // Does nothing if it's not an arrow key
//        }
//    }
//    private void update() {
//        gameTime ++;
//    }
//
//}
