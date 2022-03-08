package by.it.burov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
        private static Scanner scanner;
        static ArrayList<Double> digits = new ArrayList<>();
        static int counter = 0;

        public static void main(String[] args) {
            scanner = new Scanner(System.in);
            while (scanner.hasNext())
            try {
                readData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static void readData() throws InterruptedException {
            try {
                double digit = Double.parseDouble(scanner.nextLine());
                digits.add(digit);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                counter++;
                if(counter==5){
                    for (int i = digits.size()-1; i >= 0; i--) {
                        System.out.print(digits.get(i)+ " ");
                    }
                    throw new InterruptedException();
                }
            }
        }
}

