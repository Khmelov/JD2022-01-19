package by.it.kustova.jd02_07;

public class GenerateArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        int max = array[0];
        int indexMax = 0;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor(Math.random() * (300 - -300)) + -300;
            System.out.println(array[i]);
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            } else if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Max value " + max + " index max " + indexMax);
        System.out.println("Min value " + min);
        array[indexMax] = max * min;
        System.out.println(array[indexMax]);

    }
}
