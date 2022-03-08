package by.it.kustova.jd02_04;

import by.it.kustova.calculator.exceptions.CalcException;
import by.it.kustova.calculator.model.Scalar;
import by.it.kustova.calculator.repositories.MapRepository;
import by.it.kustova.calculator.repositories.VarRepository;
import by.it.kustova.calculator.services.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcServiceTest {

    private CalcService calcService;

    @Before
    public void setUp() throws Exception {
        VarRepository repository = new MapRepository();
        calcService = new CalcService(repository);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void calcScalarLevelA() throws CalcException {
        Scalar var = (Scalar) calcService.calc("A=2+5.3");
        Scalar var1 = (Scalar) calcService.calc("B=A*3.5");
        Scalar var2 = (Scalar) calcService.calc("B1=B+0.11*-5");
        Scalar var3 = (Scalar) calcService.calc("B2=A/2-1");
        double expected = 7.3;
        double expected1 = 25.55;
        double expected2 = 25.0;
        double expected3 = 2.65;
        double actual = var.getValue();
        double actual1 = var1.getValue();
        double actual2 = var2.getValue();
        double actual3 = var3.getValue();
        assertEquals(expected, actual, 1e-10);
        assertEquals(expected1, actual1, 1e-10);
        assertEquals(expected2, actual2, 1e-10);
        assertEquals(expected3, actual3, 1e-10);
        System.out.printf("%s%n%s%n%s%n%s%n", actual, actual1, actual2, actual3);
    }


}
