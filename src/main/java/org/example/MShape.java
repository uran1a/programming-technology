package org.example;

public class MShape implements Memento {
    protected String state;

    public MShape() {
        state = "";
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getState() {
        return state;
    }

    public Memento save() {
        return new MShapeMemento(state);
    }

    public void restore(Memento memento) {
        state = ((MShapeMemento) memento).getState();
    }
}
