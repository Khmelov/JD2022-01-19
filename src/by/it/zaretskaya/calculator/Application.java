package by.it.zaretskaya.calculator;

import by.it.zaretskaya.calculator.controllers.MainController;
import by.it.zaretskaya.calculator.exeptions.ApplicationException;
import by.it.zaretskaya.calculator.model.Var;
import by.it.zaretskaya.calculator.service.CalcService;
import by.it.zaretskaya.calculator.view.Printer;

import java.util.Scanner;

public class Application {

    public static final String END="end";
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
        Scanner scanner = new Scanner (System.in);
        while (true){
            String line = scanner.nextLine();
            if (!line.equals(END)) {
try{
    Var result = controller.process(line);
    printer.print(result);

}catch (ApplicationException e){
    printer.print(e);
}
            }else{
                System.out.println("App finished");
                break;
            }
        }

    }
}
