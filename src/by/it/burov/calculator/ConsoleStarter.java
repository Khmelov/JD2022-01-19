package by.it.burov.calculator;

import by.it.burov.calculator.controllers.MainController;
import by.it.burov.calculator.repositories.FileRepository;
import by.it.burov.calculator.repositories.VarRepository;
import by.it.burov.calculator.services.CalcService;
import by.it.burov.calculator.utils.PathFinder;
import by.it.burov.calculator.view.ConsolePrinter;
import by.it.burov.calculator.view.Printer;

public class ConsoleStarter {

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        String filename = PathFinder.getFilename(Application.class, "src", "vars.txt");
        VarRepository repository = new FileRepository(filename);
        CalcService calcService = new CalcService(repository);
        MainController controller = new MainController(calcService);
        Application application = new Application(printer, calcService, controller);
        application.run();
    }
}
