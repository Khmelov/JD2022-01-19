package by.it.burov.calculator.view;

import by.it.burov.calculator.model.Var;

public interface Printer {
    void print(Var var);
    void print(Exception e);
}
