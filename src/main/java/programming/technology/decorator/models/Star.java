package programming.technology.decorator.models;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import programming.technology.decorator.logics.ChristmasTree;
import programming.technology.decorator.logics.TreeDecorator;

public class Star extends TreeDecorator {
    public Star(ChristmasTree tree) {
        super (tree);
    }
    public void draw(Pane paneStar) {
        super.draw(paneStar);
        drawStar(paneStar);
    }
    private void drawStar(Pane paneStar) {
        Path star = new Path();
        star.getElements().addAll(
                new MoveTo(100, 0),
                new LineTo(108, 20),
                new LineTo(125, 20),
                new LineTo(114, 34),
                new LineTo(118, 50),
                new LineTo(100, 40),
                new LineTo(82, 50),
                new LineTo(86, 34),
                new LineTo(75, 20),
                new LineTo(92, 20),
                new ClosePath()
        );
        star.setFill(Color.YELLOW);
        star.setFillRule(FillRule.EVEN_ODD);
        paneStar.getChildren().addAll(star);
    }
}
