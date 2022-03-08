package by.it.chaikova.jd02_04;

import by.it.chaikova.jd02_04.controllers.MainController;
import by.it.chaikova.jd02_04.repositories.FileRepository;
import by.it.chaikova.jd02_04.repositories.VarRepository;
import by.it.chaikova.jd02_04.services.CalcService;
import by.it.chaikova.jd02_04.utils.PathFinder;
import by.it.chaikova.jd02_04.view.ConsolePrinter;
import by.it.chaikova.jd02_04.view.Printer;

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
