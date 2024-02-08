package programming.technology.decorator.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import programming.technology.decorator.logics.ChristmasTree;
import programming.technology.decorator.logics.ChristmasTreeImpl;
import programming.technology.decorator.models.Girland;
import programming.technology.decorator.models.Presents;
import programming.technology.decorator.models.Star;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button addAll;

    @FXML
    private Button addGirland;

    @FXML
    private Button addPresents;

    @FXML
    private Button addStar;

    @FXML
    private Button deleteAll;

    @FXML
    private Pane pane;

    private ChristmasTree tree;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tree = new ChristmasTreeImpl();
        tree.draw(pane);

        this.addGirland.setOnMouseClicked(this::addGarlandHandler);
        this.addStar.setOnMouseClicked(this::addStarHandler);
        this.addPresents.setOnMouseClicked(this::addPresentsHandler);
        this.addAll.setOnMouseClicked(this::addAllHandler);
        this.deleteAll.setOnMouseClicked(this::deleteAllHandler);
    }

    private void deleteAllHandler(MouseEvent event) {
        pane.getChildren().clear();
        tree = new ChristmasTreeImpl();
        tree.draw(pane);
    }

    private void addAllHandler(MouseEvent event) {
        tree = new Star(tree);
        tree.draw(pane);
        tree = new Girland(tree);
        tree.draw(pane);
        tree = new Presents(tree);
        tree.draw(pane);
    }

    private void addPresentsHandler(MouseEvent event) {
        tree = new Presents(tree);
        tree.draw(pane);
    }

    private void addStarHandler(MouseEvent event) {
        tree = new Star(tree);
        tree.draw(pane);
    }

    private void addGarlandHandler(MouseEvent event) {
        tree = new Girland(tree);
        tree.draw(pane);
    }
}
