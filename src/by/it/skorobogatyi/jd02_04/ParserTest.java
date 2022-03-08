package by.it.skorobogatyi.jd02_04;

import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.utils.Parser;
import by.it.skorobogatyi.calc.utils.VariablesStorage;
import by.it.skorobogatyi.calc.variables.AbstractVar;
import by.it.skorobogatyi.jd01_07.Vector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        double actual2 = Double.parseDouble(String.valueOf(var2));
        assertEquals(expected2, actual2, 1e-10);

        AbstractVar var3 = parser.calc("E={2,3}*(D/2)");
        String expected3 = "{10.0, 15.0}";
        String actual3 = new Vector(var3.toString()).toString();
        assertEquals(expected3, actual3);
    }

    @Test
    public void testMatrix() throws CalcException {
        AbstractVar var = parser.calc("{{1,2,3},{1,2,3}}+{{1,1,1},{1,1,1}}");
        String expected = "{{2.0, 3.0, 4.0}, {2.0, 3.0, 4.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);

        AbstractVar var2 = parser.calc("{{1,2,3},{1,2,3}}-{{1,1,1},{1,1,1}}");
        String expected2 = "{{0.0, 1.0, 2.0}, {0.0, 1.0, 2.0}}";
        String actual2 = var2.toString();
        assertEquals(expected2, actual2);

        AbstractVar var3 = parser.calc("{{1,2,3},{1,2,3}}/2");
        String expected3 = "{{0.5, 1.0, 1.5}, {0.5, 1.0, 1.5}}";
        String actual3 = var3.toString();
        assertEquals(expected3, actual3);

        AbstractVar var4 = parser.calc("{{1,2,3},{1,2,3}}*2");
        String expected4 = "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}";
        String actual4 = var4.toString();
        assertEquals(expected4, actual4);

        AbstractVar var5 = parser.calc("{{1,2,3},{1,2,3}}+10");
        String expected5 = "{{11.0, 12.0, 13.0}, {11.0, 12.0, 13.0}}";
        String actual5 = var5.toString();
        assertEquals(expected5, actual5);

        AbstractVar var6 = parser.calc("{{1,2,3},{1,2,3}}*{5,5,5}");
        String expected6 = "{30.0, 30.0}";
        String actual6 = var6.toString();
        assertEquals(expected6, actual6);

    }
}