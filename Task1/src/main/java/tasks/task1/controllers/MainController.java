package tasks.task1.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import tasks.task1.models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker fillColorPicker;

    @FXML
    private TextField heightTextField;

    @FXML
    private Button selectCircleButton;

    @FXML
    private Button selectRectangleButton;

    @FXML
    private Button selectRoundRectangleButton;

    @FXML
    private Button selectTriangleButton;

    @FXML
    private ColorPicker strokeColorPicker;

    @FXML
    private Label titleShapeLabel;

    @FXML
    private TextField widthTextField;

    private GraphicsContext gc;

    private Shape shape;
    private void drawShapesHandler(MouseEvent event){
        shape.setX(event.getX());
        shape.setY(event.getY());
        shape.draw(gc);
        titleShapeLabel.setText(shape.toString());
    }
    private void selectRoundRectangleHandler(MouseEvent event){
        if (heightTextField.getText().isEmpty() || widthTextField.getText().isEmpty())
            displayWarningMessage("Введите высота или ширину фигуры!");
        else {
            shape = new RoundRectangle(strokeColorPicker.getValue(),
                    fillColorPicker.getValue(),
                    Double.parseDouble(heightTextField.getText()),
                    Double.parseDouble(widthTextField.getText()), 15);
        }
    }
    private void selectTriangleHandler(MouseEvent event){
        if (heightTextField.getText().isEmpty() || widthTextField.getText().isEmpty())
            displayWarningMessage("Введите высота или ширину фигуры!");
        else {
            shape = new Triangle(strokeColorPicker.getValue(),
                    fillColorPicker.getValue(),
                    Double.parseDouble(heightTextField.getText()),
                    Double.parseDouble(widthTextField.getText()));
        }
    }
    private void selectRectangleHandler(MouseEvent event){
        if (heightTextField.getText().isEmpty() || widthTextField.getText().isEmpty())
            displayWarningMessage("Введите высота или ширину фигуры!");
        else {
            shape = new Rectangle(strokeColorPicker.getValue(),
                    fillColorPicker.getValue(),
                    Double.parseDouble(heightTextField.getText()),
                    Double.parseDouble(widthTextField.getText()));
        }
    }
    private void selectCircleHandler(MouseEvent event) {
        if (heightTextField.getText().isEmpty() || widthTextField.getText().isEmpty())
            displayWarningMessage("Введите высота или ширину фигуры!");
        else {
            shape = new Circle(strokeColorPicker.getValue(),
                    fillColorPicker.getValue(),
                    Double.parseDouble(heightTextField.getText()),
                    Double.parseDouble(widthTextField.getText()));
        }
    }
    private void displayWarningMessage(String text){
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Предупреждение");
        alert.setContentText(text);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();

        this.canvas.setOnMouseClicked(this::drawShapesHandler);
        this.selectRectangleButton.setOnMouseClicked(this::selectRectangleHandler);
        this.selectCircleButton.setOnMouseClicked(this::selectCircleHandler);
        this.selectRoundRectangleButton.setOnMouseClicked(this::selectRoundRectangleHandler);
        this.selectTriangleButton.setOnMouseClicked(this::selectTriangleHandler);
    }
}
