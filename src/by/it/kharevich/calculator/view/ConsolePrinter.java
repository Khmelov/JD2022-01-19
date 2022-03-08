package by.it.kharevich.calculator.view;

import by.it.kharevich.calculator.model.Var;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    @Override
    public void print(Exception e) {
        //noinspection ThrowablePrintedToSystemOut
        System.out.println(e);
    }
}
