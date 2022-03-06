package by.it.chaikova.jd02_04.model;

import by.it.chaikova.jd02_04.exceptions.CalcException;

public abstract class Var implements Operation {


    @Override
    public Var add(Var other)  throws CalcException {
        throw new CalcException(String.format("Operation addition %s + %s impossible%n",this, other));
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        throw new CalcException(String.format("Operation subtraction %s - %s impossible%n",this, other));
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        throw new CalcException(String.format("Operation multiplication %s * %s impossible%n",this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation division %s / %s impossible%n",this, other));
    }

    @Override
    public String toString() {
        return "abstract variable";
    }
}
