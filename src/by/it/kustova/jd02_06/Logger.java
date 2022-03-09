package by.it.kustova.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger implements Log {
    public static final String ROOT = "src";
    public static final String LOG_TXT = "log.txt";
    private static String fileName;
    private volatile static Logger logger;


    private Logger() {
        fileName = PathFinder.getFilename(Logger.class, ROOT, LOG_TXT);
    }

    public static Logger getInstance() {
        Logger localInstance = logger;
        if (Objects.isNull(localInstance)) {
            synchronized (Logger.class) {
                localInstance = logger;
                if (Objects.isNull(localInstance)) {
                    localInstance = new Logger();
                    logger = localInstance;
                }
            }
        }
        return localInstance;
    }

    private void log(String message) {
        try (PrintWriter output = new PrintWriter(new FileWriter(fileName))) {
            output.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void error(String messages) {
        log("error" + messages);
    }

    @Override
    public void info(String messages) {
        log("info" + messages);
    }
}
