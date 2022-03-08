package by.it.zaretskaya.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        int n = 20 + (int) (random() * ((40 - 20) + 1));
        double[] arrayA = new double[n];
        double step = (9 - 5.33) / (n + 1);
        int i = 0;
        for (double x = -5.33; x <= 9; x = x + step) {
            if (i == n) {
                break;
            } else {
                double z = cbrt(x * x + 4.5);
                arrayA[i] = z;
                i++;
            }
        }
        System.out.println("Массив A[]");
        InOut.printArray(arrayA,"A",5);

        double[] arrayB = new double[n];
        int temp = 0;
        for (int j=0;j<arrayA.length;j++) {
           if(arrayA[j]>= 3.5){
               arrayB[temp] = arrayA[j];
               temp++;
           }
        }

        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(arrayA,"B",5);


        double multiplication = 0;
        for (int q = 0; q < arrayB.length; q++) {
           multiplication *= arrayB[q];
        }

        double geometr = pow(multiplication,3);
        System.out.println("Среднее геометрическое =" + geometr);

    }
}