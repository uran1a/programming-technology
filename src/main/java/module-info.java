module programming.technology.universitystructure {
    requires javafx.controls;
    requires javafx.fxml;


    opens programming.technology.universitystructure to javafx.fxml;
    exports programming.technology.universitystructure;
}