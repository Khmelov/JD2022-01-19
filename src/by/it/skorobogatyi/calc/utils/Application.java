package by.it.skorobogatyi.calc.utils;

import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.logger.Logger;
import by.it.skorobogatyi.calc.printers.Printer;
import by.it.skorobogatyi.calc.resources.LocalisationManager;
import by.it.skorobogatyi.calc.variables.AbstractVar;

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

        String message = LocalisationManager.INSTANCE.get("message.applicationStart");
        System.out.printf("%s%n", message);
        Logger.INSTANCE.info(message);

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
                message = LocalisationManager.INSTANCE.get("message.applicationFinish");
                System.out.printf("%s", message);
                Logger.INSTANCE.info(message);
                break;
            }
        }
    }
}
