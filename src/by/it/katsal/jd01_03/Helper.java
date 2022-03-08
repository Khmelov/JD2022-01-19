package by.it.katsal.jd01_03;

class Helper {

    static double findMax(double[] array) {
        double maxElement = array[0];
        for (double element : array) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    static double findMin(double[] array) {
        double minElement = array[0];
        for (double element : array) {
            if (element < minElement) {
                minElement = element;
            }
        }
        return minElement;
    }

    static void sort(double[] array) {
        // сортировка выбором по возрастанию
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            double buffer = array[i];
            array[i] = array[minIndex];
            array[minIndex] = buffer;
        }
    }

    public static double[] multiply(double[][] matrix, double[] vector) {
        double[] resultVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultVector[i] += matrix[i][j] * vector[j];
            }
        }
        return resultVector;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixLeft[0].length; k++) {
                    resultMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
