package by.it.skorobogatyi.jd02_04;

import by.it.skorobogatyi.calc.utils.CalcException;
import by.it.skorobogatyi.calc.utils.Parser;
import by.it.skorobogatyi.calc.utils.VariablesStorage;
import by.it.skorobogatyi.calc.variables.AbstractVar;
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
    public void calc() throws CalcException {

        AbstractVar var = parser.calc("2+2");
        double expected = 4.0;
        double actual = Double.parseDouble(String.valueOf(var));
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void calcScalarLevelA() throws CalcException {

        AbstractVar var = parser.calc("A=2+5.3");
        double expected = 7.3;
        double actual = Double.parseDouble(String.valueOf(var));
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void calcSign() throws CalcException {

        AbstractVar var = parser.calc("-2.0--2");
        double expected = 0;
        double actual = Double.parseDouble(String.valueOf(var));
        assertEquals(expected, actual, 1e-10);
    }
}