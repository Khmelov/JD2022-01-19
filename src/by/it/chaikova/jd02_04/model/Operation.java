package by.it.chaikova.jd02_04.model;

import by.it.chaikova.jd02_04.exceptions.CalcException;

interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}