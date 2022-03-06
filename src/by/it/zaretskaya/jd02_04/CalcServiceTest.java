package by.it.zaretskaya.jd02_04;

import by.it.zaretskaya.calculator.exeptions.CalcException;
import by.it.zaretskaya.calculator.model.Scalar;
import by.it.zaretskaya.calculator.model.Var;
import by.it.zaretskaya.calculator.repositories.MapRepository;
import by.it.zaretskaya.calculator.repositories.VarRepository;
import by.it.zaretskaya.calculator.service.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcServiceTest {
    private CalcService calcService;

    @Before
    public void setUp() throws Exception {
        MapRepository mapRepository = new MapRepository();
        VarRepository repository = mapRepository;
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

}