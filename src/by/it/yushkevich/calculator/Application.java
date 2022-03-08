package by.it.yushkevich.calculator;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final Parser parcer;

    public Application(Printer printer, Parser parcer) {
        this.printer = printer;
        this.parcer = parcer;
    }

    public void run() {
        System.out.println("APP start");

        Scanner scanner = new Scanner(System.in);
        while (true){

            String line = scanner.nextLine();
            if (!line.equals(END)){


                try {
                    Var result = parcer.calc(line);
                    printer.print(result);;

                } catch (CalcException e) {
                    printer.print(e);
                }

            }
            else {
                System.out.println("APP finished");
                break;
            }

        }


    }
}
