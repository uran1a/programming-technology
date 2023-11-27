package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape{
    private final double LENGTH = 25;
    public Square(){
        type = "Квадрат";
    }

    @Override
    public void draw(GraphicsContext gc, Double pointX, Double pointY) {
        gc.setFill(Color.GREEN);
        gc.fillRect(pointX - (LENGTH/2), pointY - (LENGTH/2), LENGTH, LENGTH);
    }
    @Override
    public String toString(){
        return "Square";
    }
}
