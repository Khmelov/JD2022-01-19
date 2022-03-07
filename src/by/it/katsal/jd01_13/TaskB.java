package by.it.katsal.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws RuntimeException{

        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        try{
            while (true) {
                String enterLine = scanner.nextLine();
                if (!enterLine.equals("END")) {
                    double number = Double.parseDouble(enterLine);
                    if (number<0){
                        throw new ArithmeticException();
                    }
                    System.out.println(number);
                    sum = sum+number;
                    double sqrt = Math.sqrt(sum);
                    System.out.println(sqrt);
                }else{
                    break;
                }
            }
        }

        catch (ArithmeticException | NumberFormatException e){

            Class<? extends RuntimeException> eClass = e.getClass();
            String eClassName = eClass.getName(); //name exception Class

            Class<TaskB> taskBClass = TaskB.class;
            String bClassName = taskBClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();

            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName(); //class

                if (bClassName.equals(className)){

                    int lineName = stackTraceElement.getLineNumber();//line classA
                    System.out.printf("""
                             name: %s
                            class: %s
                             line: %d
                            """, eClassName,className,lineName);
                    break;
                }
            }
        }
    }
}


