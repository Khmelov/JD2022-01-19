package by.it.skorobogatyi.jd02_05.calc;


import by.it.skorobogatyi.jd02_05.calc.printers.ConsolePrinter;
import by.it.skorobogatyi.jd02_05.calc.printers.Printer;
import by.it.skorobogatyi.jd02_05.calc.utils.Application;
import by.it.skorobogatyi.jd02_05.calc.utils.Parser;

public class ConsoleRunner {

    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Parser parser = new Parser();

        Application application = new Application(printer, parser);
        application.run();
    }
}
