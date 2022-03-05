package by.it.burov.calculator.model;

import by.it.burov.calculator.ecxeptions.CalcException;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation addition %s + %s is impossible%n",this,other));
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(String.format("Operation subtract %s - %s is impossible%n",this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(String.format("Operation multiply %s*%s is impossible%n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation division %s/%s is impossible%n",this,other));
    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}
