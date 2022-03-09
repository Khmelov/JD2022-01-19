package by.it.zaretskaya.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> doubles = new ArrayList<>();
        while (true) {
            String line = scan.nextLine();
            if (!line.equals("END")) {
                try {
                    double digit = Double.parseDouble(line);
                    doubles.add(digit);
                    System.out.println(digit);
                    double sum = 0;
                    for (Double aDouble : doubles) {
                        sum = sum + aDouble;
                    }
                    double sqrt = Math.sqrt(sum);
                    if (!Double.isNaN(sqrt)) {
                        System.out.println(sqrt);
                    } else {
                        throw new ArithmeticException();
                    }
                } catch (ArithmeticException | NumberFormatException e) {
                    printException(e);
                }
            }else{
                break;
            }
        }
    }


    private static void printException(RuntimeException e) {
        Class<? extends RuntimeException> eClass = e.getClass();
        String name = eClass.getName();
        Class<TaskB> taskBClass = TaskB.class;
        String nameMain = taskBClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.equals(nameMain)) {
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("name: %s%n" +
                        "class: %s%n" +
                        "line: %s%n", name,className,lineNumber);
                break;
            }
        }
    }
}