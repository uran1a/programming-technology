package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public Circle(Color color, double height, double width){
        this.type = "Круг";
        this.color = color;
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(this.color);
        gc.fillOval(pointX - (this.width/2), pointY - (this.height/2), this.width, this.height);
    }
    @Override
    public String toString(){
        return "Circle";
    }
}
