package by.it.skorobogatyi.calc.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger implements Log {

    INSTANCE;

    public static final String ROOT = "src";
    public static final String LOG_TXT = "log.txt";
    public static final String FILENAME = FilenameGetter.getFilename(Logger.class, ROOT, LOG_TXT);


    private void log(String message) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(
                        FILENAME, true))
        ) {
            out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void error(String message) {
        log("ERROR: " + message);
    }

    @Override
    public void info(String message) {
        log("INFO: " + message);

    }
}
