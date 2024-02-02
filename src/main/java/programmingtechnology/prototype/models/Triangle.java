package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(Color color, double height, double width){
        super("Треугольник", color, height, width);
    }
    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(this.color);
        gc.fillPolygon(new double[] {pointX, pointX - (this.width/2), pointX + (this.width/2)},
                new double[] {pointY - (this.height/2), pointY + (this.height/2), pointY + (this.height/2)}, 3);
    }
}
