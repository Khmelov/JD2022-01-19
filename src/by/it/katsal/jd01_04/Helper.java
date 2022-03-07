package by.it.katsal.jd01_04;

public class Helper {

    static double findMin(double[ ] array){
        double minimum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < minimum){
                minimum = array[i];
            }
        }
        return minimum;
    }

    static double findMax(double[ ] array){
        double maximum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > maximum){
                maximum = array[i];
            }
        }
        return maximum;
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1 + i; j < array.length; j++) {
                double currentValue = array[i];
                if (currentValue > array[j]) {
                    double nextValue = array[j];
                    array[i] = nextValue;
                    array[j] = currentValue;
                }
            }
        }
    }
}
