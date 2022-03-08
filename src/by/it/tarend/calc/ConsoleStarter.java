package by.it.tarend.calc;

import by.it.tarend.calc.controllers.MainController;
import by.it.tarend.calc.repositories.FileRepository;
import by.it.tarend.calc.repositories.MapRepository;
import by.it.tarend.calc.repositories.VarRepository;
import by.it.tarend.calc.services.CalcService;
import by.it.tarend.calc.utils.PathFinder;
import by.it.tarend.calc.view.ConsolePrinter;
import by.it.tarend.calc.view.Printer;

public class ConsoleStarter {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        String fileName = PathFinder.getFileName(Application.class, "src", "vars.txt");
        VarRepository repository = new FileRepository(fileName);
        CalcService calcService = new CalcService(repository);
        MainController mainController = new MainController(calcService);
        Application application = new Application(printer, mainController);
        application.run();
    }
}
