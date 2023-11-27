package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private final double RADIUS = 25;
    public Circle(){
        type = "Круг";
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(Color.PINK);
        gc.fillOval(pointX - (RADIUS/2), pointY - (RADIUS/2), RADIUS, RADIUS);
    }
    @Override
    public String toString(){
        return "Circle";
    }
}
