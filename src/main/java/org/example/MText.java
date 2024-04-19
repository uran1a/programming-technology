package org.example;

public class MText extends MShape {
    private String text;

    public MText() {
        text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setState(String state) {
        super.setState(state);
        text = state;
    }

    @Override
    public String getState() {
        return text;
    }
}
