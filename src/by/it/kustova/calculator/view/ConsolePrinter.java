package by.it.kustova.calculator.view;

import by.it.kustova.calculator.model.Var;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Var var) {
        System.out.println(var);
    }

    @Override
    public void print(Exception e) {
        System.out.println(e.getMessage());
    }
}
