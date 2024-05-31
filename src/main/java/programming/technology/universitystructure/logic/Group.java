package programming.technology.universitystructure.logic;

import javafx.scene.control.TreeItem;

public class Group extends UniversityComponent{
    public Group(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void addComponent(UniversityComponent component) {
        throw new UnsupportedOperationException("Конечные узлы не могут добавлять компоненты.");
    }

    @Override
    public void removeComponent(UniversityComponent component) {
        throw new UnsupportedOperationException("Конечные узлы не могут удалять компоненты.");
    }

    @Override
    public TreeItem<UniversityComponent> getTreeItem() {
        return new TreeItem<>(this);
    }

    @Override
    public String toString() {
        return super.name;
    }
}
