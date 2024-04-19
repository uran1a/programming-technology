package org.example.test;

import org.example.MPolygon;
import org.example.MShape;
import org.example.MText;
import org.example.Memento;

public class MShapeTest {
    public static TestMethod testMPolygonSetState = MShapeTest::testMPolygonSetState;
    public static TestMethod testMPolygonAddPoint = MShapeTest::testMPolygonAddPoint;
    public static TestMethod testMTextSetText = MShapeTest::testMTextSetText;
    public static TestMethod testMTextUpdateTest = MShapeTest::testMTextUpdateTest;
    public static TestMethod testMementoSetState = MShapeTest::testMementoSetState;
    public static TestMethod testMementoRestore = MShapeTest::testMementoRestore;

    public static boolean testMPolygonSetState() {
        MShape shape = new MPolygon();
        shape.setState("10,20,30,40,50,60");

        return Assertions.assertEquals("10,20,30,40,50,60", shape.getState());
    }

    public static boolean testMPolygonAddPoint(){
        MShape shape = new MPolygon();
        shape.setState("10,20,30,40,50,60");
        MPolygon polygon = (MPolygon) shape;

        polygon.addPoint(70, 80);

        return Assertions.assertEquals("10,20,30,40,50,60,70,80", shape.getState());
    }

    public static boolean testMTextSetText() {
        MShape shape = new MText();
        shape.setState("Sample Text");

        return Assertions.assertEquals("Sample Text", shape.getState());
    }

    public static boolean testMTextUpdateTest(){
        MShape shape = new MText();
        shape.setState("Sample Text");

        MText text = (MText) shape;

        text.setText("Updated Text");
        return Assertions.assertEquals("Updated Text", shape.getState());
    }

    public static boolean testMementoSetState() {
        MShape shape = new MPolygon();

        shape.setState("100,200,300,400,500,600");

        return Assertions.assertEquals("100,200,300,400,500,600", shape.getState());
    }

    public static boolean testMementoRestore() {
        MShape shape = new MPolygon();
        shape.setState("10,20,30,40,50,60");

        Memento memento = shape.save();

        shape.setState("100,200,300,400,500,600");

        if(!Assertions.assertEquals("100,200,300,400,500,600", shape.getState()))
            return false;

        shape.restore(memento);

        return Assertions.assertEquals("10,20,30,40,50,60", shape.getState());
    }
}
