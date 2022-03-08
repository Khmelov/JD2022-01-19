package by.it.tarend.calc.view;

import by.it.tarend.jd02_06.PathFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger implements Log {
    INSTANCE;

    private final String fileName;
    private static final String ROOT = "src";
    private static final String SIMPLE_FILENAME = "log.txt";

    Logger() {
        fileName = PathFinder.getFileName(Logger.class, ROOT, SIMPLE_FILENAME);
    }

    @Override
    public void error(String errorMessage) {
        log("ERROR - " + errorMessage);
    }

    @Override
    public void info(String message) {
        log("Message - " + message);
    }
    
    private void log(String message) {
        try (PrintWriter printToFile = new PrintWriter(new FileWriter(fileName, true))) {
            printToFile.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
