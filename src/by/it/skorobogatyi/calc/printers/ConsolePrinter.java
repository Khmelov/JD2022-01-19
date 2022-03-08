package by.it.skorobogatyi.calc.printers;

import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.variables.AbstractVar;

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
