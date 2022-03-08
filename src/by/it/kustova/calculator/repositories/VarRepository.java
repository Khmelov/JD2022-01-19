package by.it.kustova.calculator.repositories;

import by.it.kustova.calculator.model.Var;

public interface VarRepository {
    Var save(String name, Var value);
    Var create(String varValueOrName);
}
