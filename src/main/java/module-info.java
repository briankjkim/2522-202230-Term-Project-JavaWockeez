module ca.bcit.comp2522.termproject.javawockeez {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.javawockeez to javafx.fxml;
    exports ca.bcit.comp2522.termproject.javawockeez;
}