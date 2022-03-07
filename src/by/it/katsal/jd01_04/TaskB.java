package by.it.katsal.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = scan.nextInt();
        String[] lastNames = new String[quantity];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scan.next();
        }
        int[][] salary = new int[quantity][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + lastNames[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scan.nextInt();
            }

        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартрал3", "Квартал4", "Итого");
        System.out.printf("---------------------------------------------------------------------------------------%n");
        for (int i = 0; i < salary.length; i++) {
            int sum = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%-10s:%-10d%-10d%-10d%-10d%-10d%n", lastNames[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], sum);
        }

        average(salary);
    }

    static void average(int[][] array) {
        int sumAll = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = array[i][0] + array[i][1] + array[i][2] + array[i][3];
            sumAll += sum;
            counter++;
        }
        double average = (double) sumAll / (counter * 4);
        System.out.printf("---------------------------------------------------------------------------------------%n");
        System.out.printf("%-10s%-10d%n","Итого", sumAll);
        System.out.printf("%-10s%-10.4f%n","Средняя",average);
    }
}



