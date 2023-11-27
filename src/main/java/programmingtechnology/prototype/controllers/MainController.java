package programmingtechnology.prototype.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import programmingtechnology.prototype.models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Canvas canvas;

    @FXML
    private Button cleanButton;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ListView<Shape> listView;
    private ObservableList<Shape> items;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items = FXCollections.observableArrayList(new Rectangle(), new Square(), new Triangle(), new Circle());
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setItems(items);

        this.canvas.setOnMouseClicked(this::drawShapeHandler);
        this.cleanButton.setOnMouseClicked(this::cleanCanvasHandler);
    }

    private void cleanCanvasHandler(MouseEvent event) {
        GraphicsContext gr = canvas.getGraphicsContext2D();
        gr.clearRect(0, 0, borderPane.getPrefWidth(), borderPane.getPrefHeight());
    }

    private void drawShapeHandler(MouseEvent event) {
        if(listView.getSelectionModel().getSelectedIndex() == -1) {
            displayWarningMessage("Выберите фигуру из списка!");
            return;
        }
        GraphicsContext gr = canvas.getGraphicsContext2D();
        int a = listView.getSelectionModel().getSelectedIndex();
        Shape newShape = (Shape) items.get(a).clone();
        newShape.draw(gr, event.getX(), event.getY());
    }
    private void displayWarningMessage(String text){
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Предупреждение");
        alert.setContentText(text);
        alert.showAndWait();
    }
}
