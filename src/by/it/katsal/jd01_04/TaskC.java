package by.it.katsal.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        int indexFirst = Arrays.binarySearch(array, firstElement);
        System.out.printf("Index of first element=%d%n", indexFirst);

        int indexLast = Arrays.binarySearch(array, lastElement);
        System.out.printf("Index of last element=%d%n", indexLast);

    }

    static void mergeSort(double[] array) {
        if (array.length < 2) {
            return;
        }
        int middle = array.length / 2;
        double[] leftArray = new double[middle];
        double[] rightArray = new double[array.length - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < array.length; i++) {
            rightArray[i - middle] = array[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray, middle, array.length - middle);
    }

  public static void merge(
          double[] a, double[] l, double[] r, int left, int right) {

      int i = 0, j = 0, k = 0;
      while (i < left && j < right) {
          if (l[i] <= r[j]) {
              a[k++] = l[i++];
          }
          else {
              a[k++] = r[j++];
          }
      }
      while (i < left) {
          a[k++] = l[i++];
      }
      while (j < right) {
          a[k++] = r[j++];
      }
  }

    static int binarySearch(double[ ] array, double value){
       int firstIndex = 0;
       int lastIndex = array.length - 1;
       int middle = array.length / 2;

       if(value< array[firstIndex] || value>array[lastIndex] || array[firstIndex] > array[lastIndex]){
           return -1;
       }
        while(firstIndex <= lastIndex){
            middle = (firstIndex + lastIndex) / 2;
            if(array[middle] > value){
                lastIndex = middle - 1;
            }else if(array[middle] < value){
                firstIndex = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;

    }
}
