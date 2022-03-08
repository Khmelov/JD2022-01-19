package by.it.katsal.jd01_03;


public class Runner {
    public static void main(String[] args) {
        String line = "1 2 5 9 3 12 10";
        double[] array = InOut.getArray(line);
        System.out.println("Simple output\n");
        InOut.printArray(array) ;
        String name = "V";
        int columnCout = 5;
        System.out.println("Output with columns number\n");
        InOut.printArray(array , name , columnCout ) ;
        Helper.sort(array);
        System.out.println("Output with columns number after sorting");
        InOut.printArray(array , name , 3 ) ;


        // TaskB
        double minElement = Helper.findMin(array);
        double maxElement = Helper.findMax(array);
        System.out.println("MAX: " + maxElement + "\nMIN: " + minElement);
        Helper.sort(array);
        InOut.printArray(array);

        //TaskC
        double[][] matrix = {{1, 2, 3},
                {4, 5, 6}};
        double[] vector = {1, 2, 3};
        double[][] matrixLeft = {{1, 2, 3},
                {4, 5, 6}};
        double[][] matrixRight = {{1, 2},
                {3, 4},
                {5, 6}};

        double[] resultVector = Helper.multiply (matrix, vector);
        double[][] resultMatrix = Helper.multiply(matrixLeft, matrixRight);
    }
}
