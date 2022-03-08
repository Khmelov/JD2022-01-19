package by.it.yushkevich.calculator.repository;

import by.it.yushkevich.calculator.model.Var;

public interface VarRepository {


    Var save(String name, Var value);

    Var create(String varValueOrName);


}
