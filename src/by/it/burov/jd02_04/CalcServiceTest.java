package by.it.burov.jd02_04;

import by.it.burov.calculator.ecxeptions.CalcException;
import by.it.burov.calculator.model.Scalar;
import by.it.burov.calculator.model.Vector;
import by.it.burov.calculator.repositories.MapRepository;
import by.it.burov.calculator.repositories.VarRepository;
import by.it.burov.calculator.services.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        System.out.printf("%s%n%s%n%s%n%s%n", actual1, actual2, actual3, actual4);
    }


    @Test
    public void calcScalarLevelB() throws CalcException {
        Vector var1 = (Vector) calcService.calc("C=B+(A*2)");
        Vector var2 = (Vector) calcService.calc("D=((C-0.15)-20)/(7-5)");
        Vector var3 = (Vector) calcService.calc("E={2,3}*(D/2)");
        double[] expected1 = {40.15};
        double[] actual1 = var1.getValue();
        double[] expected2 = {10};
        double[] actual2 = var2.getValue();
        double[] expected3 = {10,15};
        double[] actual3 = var3.getValue();
        assertArrayEquals(expected1, actual1, 1e-10);
        assertArrayEquals(expected2, actual2, 1e-10);
        assertArrayEquals(expected3,actual3,1e-10);
    }
}