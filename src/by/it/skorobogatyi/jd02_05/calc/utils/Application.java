package by.it.skorobogatyi.jd02_05.calc.utils;

import by.it.skorobogatyi.jd02_05.calc.printers.Printer;
import by.it.skorobogatyi.jd02_05.calc.resources.LocalisationManager;
import by.it.skorobogatyi.jd02_05.calc.variables.AbstractVar;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final Parser parser;

    public Application(Printer printer, Parser parser) {
        this.printer = printer;
        this.parser = parser;

    }

    public void run() {

        LocalisationManager lang = LocalisationManager.INSTANCE;

        System.out.printf("%s%n", lang.get("message.applicationStart"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (!line.equals(END)) {
                AbstractVar result;
                try {
                    result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                System.out.printf("%s", lang.get("message.applicationFinish"));
                System.out.println("App finished");
                break;
            }
        }
    }
}
