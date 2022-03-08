package by.it.katsal.jd01_09;

public class ConsoleRunner {

    public static void main(String[] args) {


        Printer printer = new ConsolePrinter();
        Parcer parcer = new Parcer();
        Application application = new Application(printer,parcer);
        application.run();
    }
}

