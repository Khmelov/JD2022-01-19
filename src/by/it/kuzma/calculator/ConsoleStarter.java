package by.it.kuzma.calculator;

import by.it.kuzma.calculator.controllers.MainController;
import by.it.kuzma.calculator.repositories.FileRepository;
import by.it.kuzma.calculator.repositories.MapRepository;
import by.it.kuzma.calculator.repositories.VarRepository;
import by.it.kuzma.calculator.servces.CalcService;
import by.it.kuzma.calculator.utils.PathFinder;
import by.it.kuzma.calculator.view.ConsolePrinter;
import by.it.kuzma.calculator.view.Printer;

public class ConsoleStarter {

    public static final String VARS_TXT = "vars.txt";
    public static final String ROOT = "src";

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        String filename = PathFinder.getFilename(Application.class, ROOT, VARS_TXT);
        VarRepository repository = new FileRepository(filename);
        CalcService calcService = new CalcService(repository);
        MainController mainController = new MainController(calcService);

        Application application = new Application(printer, calcService, mainController);
        application.run();
    }
}
