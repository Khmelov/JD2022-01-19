package by.it.kuzma.calculator.repositories;

import by.it.kuzma.calculator.model.Var;

public interface VarRepository {
    Var save(String name, Var value);
    Var create(String varValueOrName);
}

