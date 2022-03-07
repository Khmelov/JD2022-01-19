package by.it.zaretskaya.calculator.repositories;

import by.it.zaretskaya.calculator.model.Var;

public interface VarRepository {
    Var save (String name, Var value);
    Var create(String varValueOrName);

}
