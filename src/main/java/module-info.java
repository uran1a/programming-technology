module programming.technology.decorator {
    requires javafx.controls;
    requires javafx.fxml;

    opens programming.technology.decorator.controllers to javafx.controls, javafx.fxml, javafx.graphics;
    opens programming.technology.decorator to javafx.fxml;
    exports programming.technology.decorator;
}