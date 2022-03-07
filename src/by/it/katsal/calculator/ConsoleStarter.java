package by.it.katsal.calculator;

import by.it.katsal.calculator.controllers.MainController;
import by.it.katsal.calculator.repositories.FileRepository;
import by.it.katsal.calculator.repositories.VarRepository;
import by.it.katsal.calculator.services.CalcService;
import by.it.katsal.calculator.utils.PathFinder;
import by.it.katsal.calculator.view.ConsolePrinter;
import by.it.katsal.calculator.view.Printer;

public class ConsoleStarter {

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        String filename = PathFinder.getFilename(Application.class, "src", "vars.txt");
        VarRepository repository = new FileRepository(filename);
        CalcService calcService = new CalcService(repository);
        MainController mainController = new MainController(calcService);
        Application application = new Application(printer, calcService, mainController);
        application.run();

    }
}
