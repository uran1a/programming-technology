package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private final double HEIGHT = 25;
    private final double WIDTH = 75;
    public Rectangle(){
        type = "Прямоугольник";
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(Color.RED);
        gc.fillRect(pointX - (WIDTH/2), pointY - (HEIGHT/2), WIDTH, HEIGHT);
    }
    @Override
    public String toString(){
        return "Rectangle";
    }
}
