package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    public Rectangle(Color color, double height, double width){
        super("Прямоугольник", color, height, width);
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(this.color);
        gc.fillRect(pointX - (this.width/2), pointY - (this.height/2), this.width, this.height);
    }
}
