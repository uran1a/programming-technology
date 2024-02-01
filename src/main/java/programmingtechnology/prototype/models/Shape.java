package programmingtechnology.prototype.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable{

    // добавить поля для цвета, высоты и ширины вписываемой фигуры
  
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

    // в подкласса реализация разная, а абстрактный метод Object и так есть
}
