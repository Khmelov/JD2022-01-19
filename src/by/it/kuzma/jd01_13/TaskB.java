package by.it.kuzma.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        while (scanner.hasNext()){
            String next = scanner.next();
            if (next.equals("END")){break;}
            try {
                double number = Double.parseDouble(next);
                sum += number;
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)){
                    throw new ArithmeticException();
                } else {
                    System.out.println(/*" Entered number: %f  root: %f%n", number, */sqrt);
                }
            } catch (ArithmeticException | NumberFormatException e) {
                extracted(e);

            }

        }


    }

    private static void extracted(RuntimeException e) {
        Class<? extends RuntimeException> eClass = e.getClass();
        String eClassName = eClass.getName();//name
        Class<TaskB> taskAClass = TaskB.class;
        String aClassName = taskAClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (aClassName.equals(className)) {
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("  name: %s%n class: %s%n  line: %d%n", eClassName, className, lineNumber);
            }
        }
    }
}
