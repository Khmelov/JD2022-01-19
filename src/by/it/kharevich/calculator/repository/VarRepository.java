package by.it.kharevich.calculator.repository;

import by.it.kharevich.calculator.model.Var;

public interface VarRepository {

    Var save(String name, Var value);
    Var create(String varValueOrName);
}
