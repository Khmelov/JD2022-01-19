package by.it.chaikova.jd02_04;

import by.it.chaikova.jd02_04.controllers.MainController;
import by.it.chaikova.jd02_04.model.Var;
import by.it.chaikova.jd02_04.services.CalcService;
import by.it.chaikova.jd02_04.view.Printer;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final CalcService calcService;
    private final MainController controller;

    public Application(Printer printer, CalcService calcService, MainController controller) {
        this.printer = printer;
        this.calcService = calcService;
        this.controller = controller;
    }

    public void run() {
        System.out.println("App started");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (!line.equals(END)) {
                try {
                    Var result = controller.process(line);
                    printer.print(result);
                } catch (ArithmeticException e) {
                    printer.print(e);
                }
            } else {
                System.out.println("App finished");
                break;
            }
        }
    }
}
