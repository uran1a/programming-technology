package tasks.task2.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Circle extends Shape {
    public Circle(){
        super("Круг", Color.RED, Color.INDIGO, 75, 75);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(5.0);
        gc.setStroke(this.getStrokeColor());
        gc.strokeOval(this.getX() - (this.getHeight()/2), this.getY() - (this.getWidth()/2), this.getHeight(), this.getWidth());
        gc.setFill(this.getFillColor());
        gc.fillOval(this.getX() - (this.getHeight()/2), this.getY() - (this.getWidth()/2), this.getHeight(), this.getWidth());
    }

    @Override
    public String discriptor() {
        return String.format("Круг %s %s %f %f %f %f", getStrokeColor(), getFillColor(), getHeight(), getWidth(), getX(), getY());
    }
}