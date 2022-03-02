package by.it._classwork_.calculator;

import by.it._classwork_.calculator.controllers.MainController;
import by.it._classwork_.calculator.repositories.FileRepository;
import by.it._classwork_.calculator.repositories.VarRepository;
import by.it._classwork_.calculator.services.CalcService;
import by.it._classwork_.calculator.utils.PathFinder;
import by.it._classwork_.calculator.view.ConsolePrinter;
import by.it._classwork_.calculator.view.Printer;

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
