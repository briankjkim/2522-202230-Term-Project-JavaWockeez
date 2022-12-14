package ca.bcit.comp2522.termproject.javawockeez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import static ca.bcit.comp2522.termproject.javawockeez.GameDriver.appHeight;
import static ca.bcit.comp2522.termproject.javawockeez.GameDriver.appWidth;
public class MainMenuDriver extends Application {
    /**
     * Creates a main menu screen.
     * @param stage a scene
     * @throws IOException if FXML file cannot be found.
     */
    @Override
    public void start(final Stage stage) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuDriver.class.getResource("/MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), appWidth, appHeight);
            String mainMenu = "Escape Subject 2522";
            stage.setTitle(mainMenu);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ioe) {
            throw new IOException("Cannot find file");
        }
    }

    /**
     * Drives the game.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        launch();
    }
}