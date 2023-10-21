module tasks.task {
    requires javafx.controls;
    requires javafx.fxml;

    opens tasks.task0.controllers to javafx.controls, javafx.fxml;
    opens tasks.task0 to javafx.fxml;
    exports tasks.task0;
}