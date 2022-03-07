package by.it.katsal.jd01_02;

import java.util.Random;
import java.util.Scanner;


public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = scanner.nextInt();

        int[][] taskArray = step1(number);
        int sum = step2(taskArray);
        taskArray  = step3(taskArray);
    }

    public static int[][] step1(int number) {

        Random random = new Random();

        int[][] array = new int[number][number];

        boolean isNotContainNumber = true;
        boolean isNotContainMinusNumber = true;

        while (isNotContainNumber || isNotContainMinusNumber) {

            isNotContainNumber = true;
            isNotContainMinusNumber = true;

            for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

                for (int secondIndex = 0; secondIndex < array[firstIndex].length; secondIndex++) {
                    array[firstIndex][secondIndex] = random.nextInt(-number, number + 1);
                }
            }

            for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

                for (int secondIndex = 0; secondIndex < array[firstIndex].length; secondIndex++) {

                    if (array[firstIndex][secondIndex] == number) {
                        isNotContainNumber = false;
                    }

                    else if (array[firstIndex][secondIndex] == -number) {
                        isNotContainMinusNumber = false;
                    }
                }
            }
        }

        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

            for (int secondIndex = 0; secondIndex < array[firstIndex].length; secondIndex++) {
                System.out.print(array[firstIndex][secondIndex] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public static int step2(int[][] array) {

        int matrixSum = 0;

        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

            boolean shouldSumm = false;
            int lineSum = 0;

            for (int secondIndex = 0; secondIndex < array[firstIndex].length; secondIndex++) {

                int arrayMember = array[firstIndex][secondIndex];

                if (!shouldSumm) {

                    if (arrayMember >= 0) {
                        shouldSumm = true;
                    }

                } else {

                    if (arrayMember >= 0) {
                        break;

                    } else {
                        lineSum += arrayMember;
                    }
                }
            }
            matrixSum += lineSum;
        }
        System.out.println(matrixSum);

        return matrixSum;
    }

    public static int[][] step3(int[][] array) {

        int maxElement = array[0][0];

        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

            for (int secondIndex = 0; secondIndex < array[firstIndex].length; secondIndex++) {

                if (array[firstIndex][secondIndex] > maxElement) {
                    maxElement = array[firstIndex][secondIndex];
                }
            }
        }

        boolean[] doesLineContainMaxValue = new boolean[array.length];
        boolean[] doesColumnContainMaxValue = new boolean[array.length];

        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

            for (int secondIndex = 0; secondIndex < array[firstIndex].length; secondIndex++) {

                if (array[firstIndex][secondIndex] == maxElement) {

                    doesColumnContainMaxValue[secondIndex] = true;
                    doesLineContainMaxValue[firstIndex] = true;
                }
            }
        }

        int linesNumberInNewMatrix = array.length;

        for (int index = 0; index < doesLineContainMaxValue.length; index++) {

            if (doesLineContainMaxValue[index]) {
                linesNumberInNewMatrix--;
            }
        }

        int columnsNumberInNewMatrix = array[0].length;

        for (int index = 0; index < doesColumnContainMaxValue.length; index++) {

            if (doesColumnContainMaxValue[index]) {
                columnsNumberInNewMatrix--;
            }
        }

        int[][] finalArray = new int[linesNumberInNewMatrix][columnsNumberInNewMatrix];

        for (int i = 0, lineCounter = 0; i < array.length; i++) {

            if (!doesLineContainMaxValue[i]) {

                for (int j = 0, columnCounter = 0; j < array[i].length; j++) {

                    if (!doesColumnContainMaxValue[j]) {

                        finalArray[lineCounter][columnCounter] = array[i][j ];
                        columnCounter++;
                    }
                }
                lineCounter++;
            }
        }

        for (int firstIndex = 0; firstIndex < finalArray.length; firstIndex++) {

            for (int secondIndex = 0; secondIndex < finalArray[firstIndex].length; secondIndex++) {

                System.out.print(finalArray[firstIndex][secondIndex] + " ");
            }
            System.out.println();
        }
        return finalArray;
    }
}