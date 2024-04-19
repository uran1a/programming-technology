package org.example;

public class MShapeMemento implements Memento {
    private final String state;

    public MShapeMemento(String state) {
        this.state = state;
    }

    @Override
    public String getState() {
        return state;
    }
}
