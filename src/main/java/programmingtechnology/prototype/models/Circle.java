package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public Circle(Color color, double height, double width){
        super("Круг", color, height, width);
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(this.color);
        gc.fillOval(pointX - (this.width/2), pointY - (this.height/2), this.width, this.height);
    }
}
