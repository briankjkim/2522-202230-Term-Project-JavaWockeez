module ca.bcit.comp2522.termproject.javawockeez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens ca.bcit.comp2522.termproject.javawockeez to javafx.fxml;
    exports ca.bcit.comp2522.termproject.javawockeez;
}