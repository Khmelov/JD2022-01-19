package by.it.skorobogatyi.jd02_04;

import by.it.skorobogatyi.calc.utils.CalcException;
import by.it.skorobogatyi.calc.utils.Parser;
import by.it.skorobogatyi.calc.utils.VariablesStorage;
import by.it.skorobogatyi.calc.variables.AbstractVar;
import by.it.skorobogatyi.jd01_07.Vector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        VariablesStorage variablesStorage = new VariablesStorage();
        parser = new Parser();
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testScalar() throws CalcException {

        AbstractVar var = parser.calc("A=2+5.3");
        double expected = 7.3;
        double actual = Double.parseDouble(String.valueOf(var));
        assertEquals(expected, actual, 1e-10);

        AbstractVar var2 = parser.calc("B=A*3.5");
        double expected2 = 25.55;
        double actual2 = Double.parseDouble(String.valueOf(var2));
        assertEquals(expected2, actual2, 1e-10);

        AbstractVar var3 = parser.calc("B1=B+0.11*-5");
        double expected3 = 25;
        double actual3 = Double.parseDouble(String.valueOf(var3));
        assertEquals(expected3, actual3, 1e-10);

        AbstractVar var4 = parser.calc("B2=A/2-1");
        double expected4 = 2.65;
        double actual4 = Double.parseDouble(String.valueOf(var4));
        assertEquals(expected4, actual4, 1e-10);
    }

    @Test
    public void testVector() throws CalcException {
        AbstractVar var = parser.calc("C=B+(A*2)");
        double expected = 40.15;
        double actual = Double.parseDouble(String.valueOf(var));
        assertEquals(expected, actual, 1e-10);

        AbstractVar var2 = parser.calc("D=((C-0.15)-20)/(7-5)");
        double expected2 = 10;
        double actual2 = Double.parseDouble(String.valueOf(var));
        assertEquals(expected2, actual2, 1e-10);

        AbstractVar var3 = parser.calc("E={2,3}*{D/2}");
        Vector expected3 = new Vector("{10, 15}");
        Vector actual3 = new Vector(String.valueOf(var3));
        assertEquals(expected3, actual3);
    }
}