package programming.technology.decorator.models;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import programming.technology.decorator.logics.ChristmasTree;
import programming.technology.decorator.logics.TreeDecorator;

public class Girland extends TreeDecorator {
    public Circle[] circles = new Circle[9];
    public Girland(ChristmasTree tree){
        super(tree);
    }
    public void draw(Pane paneLight) {
        super.draw(paneLight);
        drawWithGirland(paneLight);
    }
    private void drawWithGirland(Pane paneLight) {
        FadeTransition[] ft = new FadeTransition[9];
        circles[0] = new Circle(100, 65, 10, Color.RED);
        circles[1] = new Circle(160, 205, 10, Color.BLUE);
        circles[2] = new Circle(40, 120, 10, Color.BLUE);
        circles[3] = new Circle(40, 205, 10, Color.BLUEVIOLET);
        circles[4] = new Circle(160, 120, 10, Color.BLUE);
        circles[5] = new Circle(40, 120, 10, Color.BLUE);
        circles[6] = new Circle(160, 120, 10, Color.LIME);
        circles[7] = new Circle(100, 170, 10, Color.RED);
        circles[8] = new Circle(100, 95, 10, Color.YELLOW);

        for (int i = 0; i < ft.length; i++){
            ft[i] = new FadeTransition(Duration.millis(1000), circles[i]);
            ft[i].setFromValue(1.0);
            ft[i].setToValue(0.0);
            ft[i].setCycleCount(Timeline.INDEFINITE);
            ft[i].setAutoReverse(true);
            ft[i].play();
        }

        paneLight.getChildren().addAll(circles);
    }
}
