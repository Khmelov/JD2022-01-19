package by.it.katsal.calculator.repositories;

import by.it.katsal.calculator.model.Var;

public interface VarRepository {
    Var save(String name, Var value);
    Var create(String varValueOrName);
}
