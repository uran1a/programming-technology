package org.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestService {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private List<TestMethod> testMethods = new ArrayList<>();
    public void AddTestMethod(TestMethod method){
        testMethods.add(method);
    }
    public void PrintResult(){
        for(int i = 0; i < testMethods.size(); i++){
            System.out.printf("Тест #%d | Результат: %s%n", i+1, testMethods.get(i).test() ? ANSI_GREEN + "OK" + ANSI_RESET : ANSI_RED + "WA" + ANSI_RESET);
        }
    }
}
