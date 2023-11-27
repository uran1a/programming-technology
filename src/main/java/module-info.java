module programmingtechnology.prototype {
    requires javafx.controls;
    requires javafx.fxml;

    opens programmingtechnology.prototype.controllers to javafx.controls, javafx.fxml, javafx.graphics;
    opens programmingtechnology.prototype to javafx.fxml;
    exports programmingtechnology.prototype;
}