package by.it.burov.jd02_04;

import by.it.burov.calculator.ecxeptions.CalcException;
import by.it.burov.calculator.model.Matrix;
import by.it.burov.calculator.model.Scalar;
import by.it.burov.calculator.model.Vector;
import by.it.burov.calculator.repositories.MapRepository;
import by.it.burov.calculator.repositories.VarRepository;
import by.it.burov.calculator.services.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcServiceTest {
    private CalcService calcService;

    @Before
    public void setUp() {
        VarRepository repository = new MapRepository();
        calcService = new CalcService(repository);
    }

    @After
    public void tearDown() {
    }


    @Test
    public void calcScalarLevelA() throws CalcException {
        Scalar var1 = (Scalar) calcService.calc("A=2+5.3");
        Scalar var2 = (Scalar) calcService.calc("B=A*3.5");
        Scalar var3 = (Scalar) calcService.calc("B1=B+0.11*-5");
        Scalar var4 = (Scalar) calcService.calc("B2=A/2-1");
        double expected1 = 7.3;
        double expected2 = 25.55;
        double expected3 = 25.0;
        double expected4 = 2.65;
        double actual1 = var1.getValue();
        double actual2 = var2.getValue();
        double actual3 = var3.getValue();
        double actual4 = var4.getValue();
        assertEquals(expected1, actual1, 1e-10);
        assertEquals(expected2, actual2, 1e-10);
        assertEquals(expected3, actual3, 1e-10);
        assertEquals(expected4, actual4, 1e-10);
        System.out.println("Test Task A");
        System.out.printf("%s\n%s\n%s\n%s\n", actual1, actual2, actual3, actual4);
    }


    @Test
    public void calcScalarLevelB() throws CalcException {
        Scalar var1 = (Scalar) calcService.calc("C=B+(A*2)");
        Scalar var2 = (Scalar) calcService.calc("D=((C-0.15)-20)/(7-5)");
        Vector var3 = (Vector) calcService.calc("E={2,3}*(10/2)");
        double expected1 = 40.15;
        double actual1 = var1.getValue();
        double expected2 = 10;
        double actual2 = var2.getValue();
        double[] expected3 = {10.0, 15.0};
        double[] actual3 = var3.getValue();
        assertEquals(expected1, actual1, 1e-10);
        assertEquals(expected2, actual2, 1e-10);
        assertArrayEquals(expected3, actual3, 1e-10);
        System.out.println("\nTest Task B");
        System.out.printf("%s\n%s\n", actual1, actual2);
        vectorToString(actual3);
    }


    @Test
    public void calcScalarLevelC() throws CalcException {
        Matrix var1 = (Matrix) calcService.calc("F={{1,2},{8,3}}-(1+1)");
        Vector var2 = (Vector) calcService.calc("G={{1,2},{8,3}}*({1,2}*1)");
        Matrix var3 = (Matrix) calcService.calc("k={{1,2},{8,3}} * ({{1,2},{8,3}}+{{1,2},{8,3}})");
        double[][] expected1 = {{1.0, 0.0}, {6.0, 1.0}};
        double[][] actual1 = var1.getValue();
        double[] expected2 = {5.0, 14.0};
        double[] actual2 = var2.getValue();
        double[][] expected3 = {{34.0, 16.0}, {64.0, 50.0}};
        double[][] actual3 = var3.getValue();
        System.out.println("\nTest Task C");
        matrixAssert(expected1, actual1);
        assertArrayEquals(expected2, actual2, 1e-10);
        System.out.println(matrixToString(actual1));
        vectorToString(actual2);
        System.out.println(matrixToString(actual3));
    }

    private void matrixAssert(double[][] expected, double[][] actual) {
        for (int e = 0; e < expected.length; e++) {
            for (int a = 0; a < expected[e].length; a++) {
                assertEquals(expected[e][a], actual[e][a], 1e-10);
            }
        }
    }


    private void vectorToString(double[] matrix) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        String delimiter = "";
        for (double element : matrix) {
            builder.append(delimiter).append(element);
            delimiter = ",";
        }
        builder.append('}');
        System.out.println(builder.toString());
    }

    private String matrixToString(double[][] matrix) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        for (int i = 0; i < matrix.length; i++) {
            builder.append('{');
            String delimiter = "";
            String comma = ",";
            for (int j = 0; j < matrix[i].length; j++) {
                builder.append(delimiter).append(matrix[i][j]);
                delimiter = ", ";
            }
            if (i < matrix.length - 1) {
                builder.append('}').append(comma + " ");
            } else {
                builder.append('}');
            }
        }
        builder.append('}');
        return builder.toString();
    }
}