package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double HEIGHT;
    private double WIDTH;// не константы!
    public Rectangle(){
        HEIGHT = 25;
        WIDTH = 75;
    }
// добавить второй конструктор c double HEIGHT и double WIDTH 

    
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
