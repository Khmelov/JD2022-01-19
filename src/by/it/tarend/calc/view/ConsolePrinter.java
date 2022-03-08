package by.it.tarend.calc.view;

import by.it.tarend.calc.model.Var;

public class ConsolePrinter implements Printer {


    @Override
    public void print(Var var) {
        System.out.println(var);
    }

    @Override
    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
