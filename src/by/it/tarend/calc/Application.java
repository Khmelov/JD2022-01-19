package by.it.tarend.calc;

import by.it.tarend.calc.controllers.MainController;
import by.it.tarend.calc.exceptions.ApplicationException;
import by.it.tarend.calc.model.Var;
import by.it.tarend.calc.services.CalcService;
import by.it.tarend.calc.view.Printer;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final MainController controller;

    public Application(Printer printer, MainController controller) {
        this.printer = printer;
        this.controller = controller;
    }


    public void run() {
        System.out.println("App start");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (!line.equals(END)) {
                try {
                    Var result = controller.process(line);
                    printer.print(result);
                } catch (ApplicationException e) {
                    printer.printError(e);
                }
            } else {
                System.out.println("App finished");
                break;
            }
        }
    }
}
