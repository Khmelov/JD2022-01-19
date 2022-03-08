package by.it.chaikova.jd02_04.repositories;

import by.it.chaikova.jd02_04.model.Var;

public interface VarRepository {
    Var save(String name, Var value);
    Var create(String varValueOrName);
}
