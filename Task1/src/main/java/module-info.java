module tasks.taskOne {
    requires javafx.controls;
    requires javafx.fxml;

    opens tasks.task1.controllers to javafx.controls, javafx.fxml;
    opens tasks.task1 to javafx.fxml;
    exports tasks.task1;
}