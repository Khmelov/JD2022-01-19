package by.it.zaretskaya.calculator;

import by.it.zaretskaya.calculator.controllers.MainController;
import by.it.zaretskaya.calculator.service.CalcService;
import by.it.zaretskaya.calculator.view.ConsolePrinter;
import by.it.zaretskaya.calculator.view.Printer;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        VarRepository varRepository=new VarRepository();
        CalcService calcService = new CalcService(varRepository);
        MainController mainController = new MainController(calcService);
        Application application = new Application(printer, calcService,mainController );
        application.run();
    }
}
