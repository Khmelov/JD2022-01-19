package by.it.chaikova.jd01_15;



import by.it._classwork_.jd01_14.PathFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";
    public static final String ROOT = "src";

    public static void main(String[] args) {
        int [][] matrix = createMatrix(6,4,-15,15);
        String filename = PathFinder.getFilename(TaskA.class, ROOT, MATRIX_TXT);
        save2DArrayToTxtFile(matrix,filename);
        List<String> list = getStringsFromTxtFile(filename);
        printToConsole(list);
    }

    private static void printToConsole(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    private static List<String> getStringsFromTxtFile(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException("IO error:"+ filename,e);

        }
    }

    private static void save2DArrayToTxtFile(int[][] matrix, String filename) {
       try( PrintWriter printWriter = new PrintWriter(filename)){
           for (int[] row : matrix) {
               for (int elements : row) {
                   printWriter.printf("%3d ",elements);
               }
               printWriter.println();
           }
       } catch (FileNotFoundException e) {
           throw new RuntimeException("IO error:"+ filename,e);
       }
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] createMatrix(int rows, int cols, int minValue, int maxValue) {
        int [][] array= new int[rows][cols];
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i]= minValue+ ThreadLocalRandom.current().nextInt(maxValue-minValue+1);
            }

            }
        return array;
    }
}
