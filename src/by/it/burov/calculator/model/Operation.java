package by.it.burov.calculator.model;

import by.it.burov.calculator.ecxeptions.CalcException;

interface Operation {
    Var add(Var other)throws CalcException;
    Var sub(Var other)throws CalcException;
    Var mul(Var other)throws CalcException;
    Var div(Var other)throws CalcException;
}
