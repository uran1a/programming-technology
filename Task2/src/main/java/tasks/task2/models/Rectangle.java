package tasks.task2.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Locale;

public class Rectangle extends Shape {
    public Rectangle(){
        super("Прямоугольник", Color.YELLOW, Color.OLIVE, 50, 75);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(5.0);
        gc.setStroke(this.getStrokeColor());
        gc.strokeRect(this.getX() - (this.getWidth()/2), this.getY() - (this.getHeight()/2), this.getWidth(), this.getHeight());
        gc.setFill(this.getFillColor());
        gc.fillRect(this.getX() - (this.getWidth()/2), this.getY() - (this.getHeight()/2), this.getWidth(), this.getHeight());
    }

    @Override
    public String discriptor() {
        return String.format(Locale.US, "Прямоугольник %s %s %.1f %.1f %.1f %.1f", getStrokeColor(), getFillColor(), getHeight(), getWidth(), getX(), getY());
    }
}