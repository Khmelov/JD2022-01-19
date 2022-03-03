package by.it.kuzma.calculator.repositories;

import by.it.kuzma.calculator.exceptions.ApplicationException;
import by.it.kuzma.calculator.model.Matrix;
import by.it.kuzma.calculator.model.Scalar;
import by.it.kuzma.calculator.model.Var;
import by.it.kuzma.calculator.model.Vector;
import by.it.kuzma.calculator.utils.Patterns;

import java.util.HashMap;
import java.util.Map;

public class MapRepository implements VarRepository {

    private final Map<String, Var> variables = new HashMap<>();

    public Var save(String name, Var value){
        variables.put(name, value);
        return value;
    }

    private Var getByName(String name){
       return variables.get(name);
    }

    public Var create(String varValueOrName) {
        if (varValueOrName.matches(Patterns.SCALAR)){
            return new Scalar(varValueOrName);
        } else if (varValueOrName.matches(Patterns.VECTOR)){
            return new Vector(varValueOrName);
        } else if (varValueOrName.matches(Patterns.MATRIX)){
            return new Matrix(varValueOrName);
        } else if (variables.containsKey(varValueOrName)){
            return  getByName(varValueOrName);
        }


        throw new ApplicationException("not found" + varValueOrName);
    }
}

