package by.it.burov.calculator.repositories;

import by.it.burov.calculator.ecxeptions.ApplicationException;
import by.it.burov.calculator.model.Matrix;
import by.it.burov.calculator.model.Scalar;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.model.Vector;
import by.it.burov.calculator.utils.Patterns;

public interface VarRepository {

    public Var saveVars(String name, Var var);

    public Var createVar(String varValueForName);
}
