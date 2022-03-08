package by.it.chaikova.jd02_04.view;

import by.it.chaikova.jd02_04.model.Var;

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
