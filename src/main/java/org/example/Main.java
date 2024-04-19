package org.example;

import org.example.test.MShapeTest;
import org.example.test.TestService;

import javax.swing.text.TabExpander;

public class Main {
    public static void main(String[] args) {
        var testService = new TestService();
        testService.AddTestMethod(MShapeTest.testMPolygonSetState);
        testService.AddTestMethod(MShapeTest.testMPolygonAddPoint);
        testService.AddTestMethod(MShapeTest.testMTextSetText);
        testService.AddTestMethod(MShapeTest.testMTextUpdateTest);
        testService.AddTestMethod(MShapeTest.testMementoSetState);
        testService.AddTestMethod(MShapeTest.testMementoRestore);

        testService.PrintResult();
    }
}