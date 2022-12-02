package ca.bcit.comp2522.termproject.javawockeez;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenu {
    @FXML
    private Label welcomeText;

    @FXML
    protected final void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
