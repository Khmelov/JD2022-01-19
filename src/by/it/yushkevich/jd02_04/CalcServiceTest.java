package by.it.yushkevich.jd02_04;

import by.it.yushkevich.calculator.exceptions.CalcException;
import by.it.yushkevich.calculator.model.Scalar;
import by.it.yushkevich.calculator.model.Var;
import by.it.yushkevich.calculator.repository.MapRepository;
import by.it.yushkevich.calculator.repository.VarRepository;
import by.it.yushkevich.calculator.services.CalcService;
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
        Scalar var = (Scalar) calcService.calc("2+2");
        double expected = 4.0;
        double actual = var.getValue();
        assertEquals(expected,actual,1e-10);

    }

    @Test
    public void calcScalarLevelA() throws CalcException {
        Scalar var = (Scalar) calcService.calc("A=2+5.3");
        double expected = 7.3;
        double actual = var.getValue();
        assertEquals(expected,actual,1e-10);

        Scalar var1 = (Scalar) calcService.calc("B=A*3.5");
        double expected1 = 25.55;
        double actual1 = var1.getValue();
        assertEquals(expected1,actual1,1e-10);


        Scalar var2 = (Scalar) calcService.calc("B1=B+0.11*-5");
        double expected2 = 25;
        double actual2 = var2.getValue();
        assertEquals(expected2,actual2,1e-10);


        Scalar var3 = (Scalar) calcService.calc("B2=A/2-1");
        double expected3 = 2.65;
        double actual3 = var3.getValue();
        assertEquals(expected3,actual3,1e-10);


//        Scalar var4 = (Scalar) calcService.calc("A=2+2*2");
//        double expected4 = 6.0;
//        double actual4 = var4.getValue();
//        assertEquals(expected4,actual4,1e-10);


    }

        @Test
    public void calcScalarSign() throws CalcException {
        Scalar var = (Scalar) calcService.calc("-2.0--2");
        double expected = 0;
        double actual = var.getValue();
        assertEquals(expected,actual,1e-10);

    }



}