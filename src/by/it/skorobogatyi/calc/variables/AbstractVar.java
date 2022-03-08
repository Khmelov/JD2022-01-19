package by.it.skorobogatyi.calc.variables;

import by.it.skorobogatyi.calc.logger.Logger;
import by.it.skorobogatyi.calc.resources.LocalisationManager;
import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.utils.Operation;

public abstract class AbstractVar implements Operation {


    @Override
    public abstract AbstractVar add(AbstractVar other) throws CalcException;

    public abstract AbstractVar add(Scalar other) throws CalcException;

    public abstract AbstractVar add(Vector other) throws CalcException;

    public abstract AbstractVar add(Matrix other) throws CalcException;


    @Override
    public abstract AbstractVar sub(AbstractVar other) throws CalcException;

    public abstract AbstractVar sub(Scalar other) throws CalcException;

    public abstract AbstractVar sub(Vector other) throws CalcException;

    public abstract AbstractVar sub(Matrix other) throws CalcException;


    @Override
    public abstract AbstractVar mul(AbstractVar other) throws CalcException;

    public abstract AbstractVar mul(Scalar other) throws CalcException;

    public abstract AbstractVar mul(Vector other) throws CalcException;

    public abstract AbstractVar mul(Matrix other) throws CalcException;


    @Override
    public abstract AbstractVar div(AbstractVar other) throws CalcException;

    public abstract AbstractVar div(Scalar other) throws CalcException;

    public abstract AbstractVar div(Vector other) throws CalcException;

    public abstract AbstractVar div(Matrix other) throws CalcException;


    @Override
    public String toString() {
        String message = LocalisationManager.INSTANCE.get("error.unknownVariable");
        Logger.getInstance().error(message);
        return String.format("%s", message);
    }
}
