package by.it.katsal.jd01_13;

import java.util.*;

public class TaskC {


    private static Scanner scanner;
    private static int stop=0;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            readData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void readData() throws InterruptedException {
        List<Double> array = new ArrayList<>();


        while (true){
            String realNumber = scanner.nextLine();
            if (new Scanner(realNumber).hasNextInt()) {
                double number = Double.parseDouble(realNumber);
                array.add(number);
            }else{
                stop++;


                Thread.sleep(100);
                for (int i = 0, j = array.size() - 1; i < j; i++) {
                    array.add(i, array.remove(j));
                }
                StringJoiner stringJoiner = new StringJoiner(" ");
                for (Double aDouble : array) {
                    stringJoiner.add(aDouble.toString());
                }
                System.out.println(stringJoiner);
                for (int i = 0, j = array.size() - 1; i < j; i++) {
                    array.add(i, array.remove(j));
                }
            }


            if (stop == 5){
                throw new InterruptedException();
            }
        }
    }
}



