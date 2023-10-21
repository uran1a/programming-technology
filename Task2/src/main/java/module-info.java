module tasks.taskTwo {
    requires javafx.controls;
    requires javafx.fxml;

    opens tasks.task2.controllers to javafx.controls, javafx.fxml;
    opens tasks.task2 to javafx.fxml;
    exports tasks.task2;
}