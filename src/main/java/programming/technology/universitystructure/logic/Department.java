package programming.technology.universitystructure.logic;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

public class Department extends UniversityComponent {
    private List<UniversityComponent> components = new ArrayList<>();
    public Department(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void addComponent(UniversityComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(UniversityComponent component) {
        components.remove(component);
    }

    @Override
    public TreeItem<UniversityComponent> getTreeItem() {
        TreeItem<UniversityComponent> treeItem = new TreeItem<>(this);
        for (UniversityComponent component : components) {
            treeItem.getChildren().add(component.getTreeItem());
        }
        return treeItem;
    }

    @Override
    public String toString() {
        return super.name;
    }
}
