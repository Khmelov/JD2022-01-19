package by.it.skorobogatyi.jd02_05.calc.printers;

import by.it.skorobogatyi.jd02_05.calc.utils.CalcException;
import by.it.skorobogatyi.jd02_05.calc.variables.AbstractVar;

public class ConsolePrinter implements Printer {
    @Override
    public void print(AbstractVar abstractVar) {
        System.out.println(abstractVar);
    }

    @Override
    public void print(CalcException e) {
        System.out.println(e.getMessage());
    }
}
