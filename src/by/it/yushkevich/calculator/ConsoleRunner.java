package by.it.yushkevich.calculator;

public class ConsoleRunner {
    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        VarRepository varRepository = new VarRepository();
        Parser parser = new Parser(varRepository);
        Application application = new Application(printer, parser);

        application.run();
    }
}
