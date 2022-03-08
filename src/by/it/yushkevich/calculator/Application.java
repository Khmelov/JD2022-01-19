package by.it.yushkevich.calculator;

import by.it.yushkevich.calculator.controllers.MainController;
import by.it.yushkevich.calculator.exceptions.ApplicationException;
import by.it.yushkevich.calculator.model.Var;
import by.it.yushkevich.calculator.services.CalcService;
import by.it.yushkevich.calculator.view.Printer;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final CalcService parcer;
    private final MainController controller;

    public Application(Printer printer, CalcService parcer, MainController controller) {
        this.printer = printer;
        this.parcer = parcer;
        this.controller = controller;
    }

    public void run() {
        System.out.println("APP start");

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String line = scanner.nextLine();
            if (!line.equals(END)) {

                try {
                    Var result = controller.process(line);
                    printer.print(result);
                } catch (ApplicationException e) {
                    printer.print(e);
                }

            } else {
                System.out.println("APP finished");
                break;
            }

        }


    }
}
