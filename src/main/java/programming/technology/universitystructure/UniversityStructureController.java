package programming.technology.universitystructure;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import programming.technology.universitystructure.logic.Department;
import programming.technology.universitystructure.logic.Faculty;
import programming.technology.universitystructure.logic.Group;
import programming.technology.universitystructure.logic.UniversityComponent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class UniversityStructureController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private TextField nameField;

    @FXML
    private Button remoteButton;

    @FXML
    private TreeView<UniversityComponent> treeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Faculty rootFaculty = new Faculty("ВГТУ");
        TreeItem<UniversityComponent> rootItem = rootFaculty.getTreeItem();
        rootItem.setExpanded(true);

        treeView.setRoot(rootItem);
        treeView.setShowRoot(true);

        nameField.setPromptText("Название");
        addButton.setOnAction(e -> addElement());
        remoteButton.setOnAction(e -> removeElement());
    }

    private void addElement() {
        String name = nameField.getText();
        if (name.isEmpty()){
            displayWarningMessage("Выберите компонент, в который необходимо добавить компонент.");
            return;
        }

        TreeItem<UniversityComponent> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;

        UniversityComponent newComponent;
        if (selectedItem.getValue() instanceof Faculty || selectedItem.getValue() instanceof Department) {
            newComponent = new Department(name);
        } else {
            newComponent = new Group(name);
        }

        TreeItem<UniversityComponent> newItem = newComponent.getTreeItem();
        selectedItem.getChildren().add(newItem);
        selectedItem.setExpanded(true);

        selectedItem.getValue().addComponent(newComponent);

        nameField.clear();
    }

    private void removeElement() {
        TreeItem<UniversityComponent> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if (selectedItem == null || selectedItem == treeView.getRoot()){
            displayWarningMessage("Выберите компонент, в который хотите удалить.");
            return;
        }

        TreeItem<UniversityComponent> parentItem = selectedItem.getParent();
        if (parentItem != null) {
            parentItem.getChildren().remove(selectedItem);
            parentItem.getValue().removeComponent(selectedItem.getValue());
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