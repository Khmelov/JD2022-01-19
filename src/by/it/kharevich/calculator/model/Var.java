package by.it.kharevich.calculator.model;

import by.it.kharevich.calculator.exceptions.CalcException;
import by.it.kharevich.calculator.resources.ResourceManager;
import by.it.kharevich.calculator.utils.ExceptionMessages;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_ADD)
                + " %s + %s" + ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_IMP)+"%n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_SUB)
                + " %s - %s" + ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_IMP)+"%n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_MULT)
                + " %s * %s" + ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_IMP)+"%n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_DIV)
                + " %s / %s" + ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_IMP)+"%n", this, other));
    }

    @Override
    public String toString() {
        return ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_ABSTR);
    }
}
