package by.it.tarend.calc.repositories;

import by.it.tarend.calc.exceptions.ApplicationException;
import by.it.tarend.calc.model.Matrix;
import by.it.tarend.calc.model.Scalar;
import by.it.tarend.calc.model.Var;
import by.it.tarend.calc.model.Vector;
import by.it.tarend.calc.utils.Patterns;

import java.util.HashMap;
import java.util.Map;

public class MapRepository implements VarRepository{

    private final Map<String, Var> variables = new HashMap<>();

    public Var save(String name, Var value) {
        variables.put(name, value);
        return value;
    }

    private Var getByName(String name) {
        return variables.get(name);
    }

    public Var create(String varValueOrName) {
        if (varValueOrName.matches(Patterns.SCALAR)) {
            return new Scalar(varValueOrName);
        } else if (varValueOrName.matches(Patterns.VECTOR)) {
            return new Vector(varValueOrName);
        } else if (varValueOrName.matches(Patterns.MATRIX)) {
            return new Matrix(varValueOrName);
        } else if (variables.containsKey(varValueOrName)) {
            return getByName(varValueOrName);
        }

        throw new ApplicationException("not found " + varValueOrName);
    }
}
