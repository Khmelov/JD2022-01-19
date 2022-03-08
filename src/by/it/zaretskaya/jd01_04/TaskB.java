package by.it.zaretskaya.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        System.out.println("Введите количество человек в числах:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int quarter = 4; // кварталы

        // создаем массив для фамилий размером каунт
        String[] secondName = new String[count];
        // заполняем массив с фамилиями
        System.out.println("Введите их фамилии");
        for (int i = 0; i < secondName.length; i++) {
            secondName[i] = scanner.next();
        }


        int[][] salary = new int[secondName.length][quarter];
        //массив для зарплат заполняем
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Введите зарплаты для %s", secondName[i]);
            for (int j = 0; j < quarter; j++) {
                // System.out.printf("Введите зарплаты для %s", secondName[i]);
                salary[i][j] = scanner.nextInt();

            }
        }

        createTable(secondName, salary);


    }

    private static void createTable(String[] secondName, int[][] salary) {

        String family = "Фамилия";
        String kv1 = "Квартал1";
        String kv2 = "Квартал2";
        String kv3 = "Квартал3";
        String kv4 = "Квартал4";
        String itogooo = "Итого";
        double finalSumm = 0;

        System.out.printf("%10s  %-12s  %-12s  %-12s  %-12s  %-12s\n", family, kv1, kv2, kv3, kv4, itogooo);
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < secondName.length; i++) {
            System.out.printf("%10s:  ", secondName[i]);
            int summ = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-12d  ", salary[i][j]);
                summ = summ + salary[i][j];

            }
            System.out.printf("%-4d ", summ);
            finalSumm = finalSumm + summ;
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------");
        double average = finalSumm / 12;
        System.out.printf("Итого: %f\n", finalSumm);
        System.out.printf("Средняя: %f", average);

    }


}
