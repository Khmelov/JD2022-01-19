package by.it._classwork_.jd02_04;

import by.it._classwork_.calculator.exceptions.CalcException;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.repositories.MapRepository;
import by.it._classwork_.calculator.repositories.VarRepository;
import by.it._classwork_.calculator.services.CalcService;
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
    public void calc() throws CalcException {
        Scalar var = (Scalar) calcService.calc("2+2");
        double expected = 4.0;
        double actual = var.getValue();
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void calcScalarLevelA() throws CalcException {
        Scalar var = (Scalar) calcService.calc("A=2+2*2");
        double expected = 6.0;
        double actual = var.getValue();
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void calcScalarSign() throws CalcException {
        Scalar var = (Scalar) calcService.calc("-2.0--2");
        double expected = 0;
        double actual = var.getValue();
        assertEquals(expected, actual, 1e-10);
    }
}