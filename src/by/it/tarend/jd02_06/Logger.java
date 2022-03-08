package by.it.tarend.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger implements Log{

    private static String fileName = null;
    private static final String ROOT = "src";
    private static final String SIMPLE_FILENAME = "log.txt";
    private volatile static Logger logger;

    private Logger() {
        fileName = PathFinder.getFileName(Logger.class, ROOT, SIMPLE_FILENAME);
    }

    public static Logger getInstance() {
        Logger localInstance = logger;
        if (Objects.isNull(localInstance)) {
            synchronized (Logger.class) {
                localInstance = logger;
                if (Objects.isNull(localInstance)) {
                    logger = localInstance = new Logger();
                }
            }
        }
        return localInstance;
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
