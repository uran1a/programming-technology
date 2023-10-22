package tasks.task2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import tasks.task2.models.*;
import tasks.task2.utils.FileParser;

import java.io.File;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    @FXML
    private Button backShapeButton;

    @FXML
    private Canvas canvas;

    @FXML
    private Label descLabel;

    @FXML
    private TextField nameShapeTextField;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private Button saveShapesButton;

    private Deque<Shape> shapes;
    GraphicsContext gc;
    private FileChooser fileChooser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shapes = new ArrayDeque<>();

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.maxWidth(Double.MAX_VALUE), canvas.maxHeight(Double.MAX_VALUE));

        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:\\Users\\voron\\Desktop"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        this.canvas.setOnMouseClicked(this::drawShapeHandler);
        this.backShapeButton.setOnMouseClicked(this::backShapeHandler);
        this.openMenuItem.setOnAction(this::openFileHandler);
        this.saveMenuItem.setOnAction(this::saveFileHandler);
    }

    private void saveFileHandler(ActionEvent actionEvent){
        int uniqueNumber =  String.valueOf(System.currentTimeMillis()).hashCode();
        fileChooser.setInitialFileName("shapes_"+uniqueNumber+".txt");
        File file = fileChooser.showSaveDialog(canvas.getScene().getWindow());
        if (file != null)
            FileParser.parseToString(shapes, file);
        else
            displayWarningMessage("Неверный файл");
    }
    private void openFileHandler(ActionEvent actionEvent) {
        var selectedFile = fileChooser.showOpenDialog(canvas.getScene().getWindow());
        Deque<Shape> fileShapes = FileParser.parseToShapes(selectedFile);
        if(fileShapes.size() != 0){
            this.shapes = fileShapes;
            drawShapesOnCleanCanvas();
        }
        else
            displayWarningMessage("Файл пустой или с некоррестными данными");
    }

    private void backShapeHandler(MouseEvent event){
        if(!shapes.isEmpty()){
            shapes.pop();

            drawShapesOnCleanCanvas();
        }
        else{
            displayWarningMessage("На холсте нет фигур");
        }
    }

    private void drawShapesOnCleanCanvas(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.maxWidth(Double.MAX_VALUE), canvas.maxHeight(Double.MAX_VALUE));

        Iterator<Shape> descIter = this.shapes.descendingIterator();
        while (descIter.hasNext()){
            descIter.next().draw(gc);
        }
    }

    private void drawShapeHandler(MouseEvent event){
        if(!nameShapeTextField.getText().isEmpty()){
            var nameShape = nameShapeTextField.getText();
            var shape = new ShapeFactory().createShape(nameShape);
            if(shape == null){
                displayWarningMessage("Такой фигуры нет в списке");
            }
            else{
                GraphicsContext gc = canvas.getGraphicsContext2D();
                shape.setX(event.getX());
                shape.setY(event.getY());

                shape.draw(gc);
                descLabel.setText(shape.discriptor());

                shapes.push(shape);
            }
        }
        else{
            displayWarningMessage("Введите название фигуры");
        }

    }
    private void displayWarningMessage(String text){
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Предупреждение");
        alert.setContentText(text);
        alert.showAndWait();
    }
}
