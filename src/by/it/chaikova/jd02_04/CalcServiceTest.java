package by.it.chaikova.jd02_04;

import by.it.chaikova.jd02_04.exceptions.CalcException;
import by.it.chaikova.jd02_04.model.Scalar;
import by.it.chaikova.jd02_04.model.Var;
import by.it.chaikova.jd02_04.repositories.MapRepository;
import by.it.chaikova.jd02_04.repositories.VarRepository;
import by.it.chaikova.jd02_04.services.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import  static org.junit.Assert.assertEquals;

public class CalcServiceTest {

    private CalcService calcService;

    @Before
    public void setUp() throws Exception {
        VarRepository repository= new MapRepository();
        calcService = new CalcService(repository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calc() throws CalcException {
        Var var = calcService.calc("2+2");
        double expected = 4.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    public void calcScalarLevelA () throws CalcException {
        Scalar var = (Scalar) calcService.calc("A=2+5.3");
        double expected = 7.3;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    public void calcScalarSign () throws CalcException {
        Scalar var = (Scalar) calcService.calc("-2.0--2");
        double expected = 0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected,actual,1e-10);
    }
}