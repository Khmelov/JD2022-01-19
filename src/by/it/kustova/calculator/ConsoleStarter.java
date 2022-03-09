package by.it.kustova.calculator;

import by.it.kustova.calculator.controllers.MainController;
import by.it.kustova.calculator.repositories.FileRepository;
import by.it.kustova.calculator.repositories.VarRepository;
import by.it.kustova.calculator.services.CalcService;
import by.it.kustova.calculator.utils.PathFinder;
import by.it.kustova.calculator.view.ConsolePrinter;
import by.it.kustova.calculator.view.Printer;

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
