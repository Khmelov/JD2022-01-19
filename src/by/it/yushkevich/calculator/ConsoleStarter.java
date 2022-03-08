package by.it.yushkevich.calculator;

import by.it.yushkevich.calculator.controllers.MainController;
import by.it.yushkevich.calculator.repository.FileRepository;
import by.it.yushkevich.calculator.repository.MapRepository;
import by.it.yushkevich.calculator.repository.VarRepository;
import by.it.yushkevich.calculator.services.CalcService;
import by.it.yushkevich.calculator.utils.PathFinder;
import by.it.yushkevich.calculator.view.ConsolePrinter;

public class ConsoleStarter {
    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        String fileName = PathFinder.getFileName(Application.class, "src", "vars.txt");
        VarRepository repository = new FileRepository(fileName);
        CalcService calcService = new CalcService(repository);
        MainController mainController = new MainController(calcService);
        Application application = new Application(printer, calcService, mainController);

        application.run();
    }
}
