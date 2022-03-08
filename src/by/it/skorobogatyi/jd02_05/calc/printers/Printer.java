package by.it.skorobogatyi.jd02_05.calc.printers;

import by.it.skorobogatyi.jd02_05.calc.utils.CalcException;
import by.it.skorobogatyi.jd02_05.calc.variables.AbstractVar;

public interface Printer {
    void print(AbstractVar abstractVar);

    void print(CalcException e);
}
