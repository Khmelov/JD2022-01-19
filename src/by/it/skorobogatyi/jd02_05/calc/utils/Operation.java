package by.it.skorobogatyi.jd02_05.calc.utils;

import by.it.skorobogatyi.jd02_05.calc.variables.AbstractVar;

public interface Operation {

    AbstractVar add(AbstractVar other) throws CalcException;

    AbstractVar sub(AbstractVar other) throws CalcException;

    AbstractVar mul(AbstractVar other) throws CalcException;

    AbstractVar div(AbstractVar other) throws CalcException;

}
