package by.it.kustova.calculator.repositories;

import by.it.kustova.calculator.exceptions.ApplacitionException;
import by.it.kustova.calculator.model.Matrix;
import by.it.kustova.calculator.model.Scalar;
import by.it.kustova.calculator.model.Var;
import by.it.kustova.calculator.model.Vector;
import by.it.kustova.calculator.utils.Patterns;

import java.util.HashMap;
import java.util.Map;

public class MapRepository implements VarRepository {

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
        throw new ApplacitionException("not found " + varValueOrName);
    }
}
