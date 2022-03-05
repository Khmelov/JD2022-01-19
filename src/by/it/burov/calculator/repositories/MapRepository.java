package by.it.burov.calculator.repositories;

import by.it.burov.calculator.ecxeptions.ApplicationException;
import by.it.burov.calculator.model.Matrix;
import by.it.burov.calculator.model.Scalar;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.model.Vector;
import by.it.burov.calculator.utils.Patterns;

import java.util.HashMap;
import java.util.Map;


public class MapRepository implements VarRepository {

    private static final Map<String, Var> vars = new HashMap<>();

    public Var saveVars(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    private Var getByName(String name) {
        return vars.get(name);
    }

    public Var createVar(String varValueForName) {
        if (varValueForName.matches(Patterns.SCALAR)) {
            return new Scalar(varValueForName);
        } else if (varValueForName.matches(Patterns.VECTOR)) {
            return new Vector(varValueForName);
        } else if (varValueForName.matches(Patterns.MATRIX)) {
            return new Matrix(varValueForName);
        } else if (vars.containsKey(varValueForName)) {
            return getByName(varValueForName);
        }

        throw new ApplicationException("not found " + varValueForName);
    }
}
