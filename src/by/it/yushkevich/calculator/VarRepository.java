package by.it.yushkevich.calculator;

import java.util.HashMap;
import java.util.Map;

public class VarRepository {
    private Map<String, Var> variables = new HashMap<>();

    Var save(String name, Var value) {
        variables.put(name, value);
        return value;
    }

    Var getByName(String name) {
        return variables.get(name);
    }

    public Var create(String varValueOrName) throws CalcException {
        if (varValueOrName.matches(Patterns.SCALAR)) {
            return new Scalar(varValueOrName);
        } else if (varValueOrName.matches(Patterns.VECTOR)) {
            return new Vector(varValueOrName);
        } else if (varValueOrName.matches(Patterns.MATRIX)) {
            return new Matrix(varValueOrName);
        } else if (variables.containsKey(varValueOrName)) {
            return getByName(varValueOrName);
        }
        throw new CalcException("not found " + varValueOrName);
    }
}
