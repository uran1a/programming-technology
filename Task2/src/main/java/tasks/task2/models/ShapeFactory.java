package tasks.task2.models;

public class ShapeFactory {
    public Shape createShape(String name) {
        return switch (name) {
            case "Круг" -> new Circle();
            case "Прямоугольник" -> new Rectangle();
            case "Треугольник" -> new Triangle();
            default -> null;
        };
    }
}
