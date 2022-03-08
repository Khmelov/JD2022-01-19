package by.it.skorobogatyi.calc.utils;

import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.variables.AbstractVar;

public interface Operation {

    AbstractVar add(AbstractVar other) throws CalcException;

    AbstractVar sub(AbstractVar other) throws CalcException;

    AbstractVar mul(AbstractVar other) throws CalcException;

    AbstractVar div(AbstractVar other) throws CalcException;

}
