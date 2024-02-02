package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable{
    protected String type;
    protected Color color;
    protected double height;
    protected double width;
    public Shape(String type, Color color, double height, double width){
        this.type = type;
        this.color = color;
        this.height = height;
        this.width = width;
    }
    public abstract void draw(GraphicsContext gr, Double pointX, Double pointY);
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
