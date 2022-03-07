package by.it.tarend.jd02_04;

import by.it.tarend.calc.exceptions.CalcException;
import by.it.tarend.calc.model.Matrix;
import by.it.tarend.calc.model.Scalar;
import by.it.tarend.calc.model.Vector;
import by.it.tarend.calc.repositories.MapRepository;
import by.it.tarend.calc.repositories.VarRepository;
import by.it.tarend.calc.services.CalcService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcServiceTest {

    private static CalcService calcService;

    @BeforeClass
    public static void setUp() throws Exception {
        VarRepository repository = new MapRepository();
        calcService = new CalcService(repository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calcScalarTaskA() throws CalcException {
        Scalar var1 = (Scalar) calcService.calc("A=2+5.3");
        double expected1 = 7.3;
        double real1 = var1.getValue();
        assertEquals(expected1, real1, 1e-10);

        Scalar var2 = (Scalar) calcService.calc("B=A*3.5");
        double expected2 = 25.55;
        double real2 = var2.getValue();
        assertEquals(expected2, real2, 1e-10);

        Scalar var3 = (Scalar) calcService.calc("B1=B+0.11*-5");
        double expected3 = 25;
        double real3 = var3.getValue();
        assertEquals(expected3, real3, 1e-10);

        Scalar var4 = (Scalar) calcService.calc("B2=A/2-1");
        double expected4 = 2.65;
        double real4 = var4.getValue();
        assertEquals(expected4, real4, 1e-10);

        // почему значения посчитанные в A не находятся при выполнении B?

        Scalar var5 = (Scalar) calcService.calc("C=B+(A*2)");
        double expected5 = 40.15;
        double real5 = var5.getValue();
        assertEquals(expected5, real5, 1e-10);

        Vector var6 = (Vector) calcService.calc("E={2,3}*(10/2)");
        String real6 = var6.toString();
        String expected6 = "{10.0,15.0}";
        assertEquals(expected6, real6);

    }

    @Test
    public void calcVectorTaskB() throws CalcException {
        Scalar var1 = (Scalar) calcService.calc("C=B+(A*2)");  // не передается значение А
        double expected1 = 40.15;
        double real1 = var1.getValue();
        assertEquals(expected1, real1, 1e-10);

        Scalar var2 = (Scalar) calcService.calc("D=((C-0.15)-20)/(7-5)"); // deadloop =(
        double expected2 = 10;
        double real2 = var2.getValue();
        assertEquals(expected2, real2, 1e-10);

        Vector var3 = (Vector) calcService.calc("E={2,3}*(D/2)");
        String real3 = var3.toString();
        String expected3 = "{10.0,15.0}";
        assertEquals(expected3, real3);
    }

    @Test
    public void calcMatrixTaskC() throws CalcException {
        Matrix var1 = (Matrix) calcService.calc("{{1,2,3},{3,2,1}}+{{4,5,6},{6,5,4}}");
        String expected1 = "{{5.0,7.0,9.0},{9.0,7.0,5.0}}";
        String real1 = var1.toString();
        assertEquals(expected1, real1);

        Matrix var2 = (Matrix) calcService.calc("{{1,2},{3,2}}*{{4,5},{6,5}}");
        String expected2 = "{{16.0,15.0},{24.0,25.0}}";
        String real2 = var2.toString();
        assertEquals(expected2, real2);

        Matrix var3 = (Matrix) calcService.calc("{{1,2,3},{3,2,1}}*2");
        String expected3 = "{{2.0,4.0,6.0},{6.0,4.0,2.0}}";
        String real3 = var3.toString();
        assertEquals(expected3, real3);

        Vector var4 = (Vector) calcService.calc("{{1,2,3},{3,2,1}}*{3,2,3}");
        String expected4 = "{7.0,13.0}";
        String real4 = var4.toString();
        assertEquals(expected4, real4);

        Matrix var5 = (Matrix) calcService.calc("{{1,2,3},{3,2,1}}+100");
        String expected5 = "{{101.0,102.0,103.0},{103.0,102.0,101.0}}";
        String real5 = var5.toString();
        assertEquals(expected5, real5);
    }
}