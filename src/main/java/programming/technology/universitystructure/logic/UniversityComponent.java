package programming.technology.universitystructure.logic;

import javafx.scene.control.TreeItem;

public abstract class UniversityComponent {
    String name;

    public UniversityComponent(String name){
        this.name = name;
    }

    public abstract String getName();

    public abstract void addComponent(UniversityComponent component);

    public abstract void removeComponent(UniversityComponent component);

    public abstract TreeItem<UniversityComponent> getTreeItem();
}
