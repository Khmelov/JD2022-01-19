package by.it.kuzma.jd02_04;

import by.it.kuzma.calculator.exceptions.CalcException;
import by.it.kuzma.calculator.model.Scalar;
import by.it.kuzma.calculator.repositories.MapRepository;
import by.it.kuzma.calculator.repositories.VarRepository;
import by.it.kuzma.calculator.servces.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        Scalar var = (Scalar) calcService.calc("2 + 2");
        double expected = 4.0;
        double actual = var.getValue();
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void calcScalarLevelA() throws CalcException {
        Scalar var = (Scalar) calcService.calc("A=2+5.3");
        double expected = 7.3;
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