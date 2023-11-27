package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    private final double HEIGHT = 25;
    private final double WIDTH = 75;
    public Triangle(){
        type = "Треугольник";
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[] {pointX, pointX - (WIDTH/2), pointX + (WIDTH/2)}, new double[] {pointY - (HEIGHT/2), pointY + (HEIGHT/2), pointY + (HEIGHT/2)}, 3);
    }
    @Override
    public String toString(){
        return "Triangle";
    }
}
