package by.it._classwork_.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger implements Log {

    public static final String SRC = "src";
    public static final String LOG_TXT = "log.txt";
    public static String filename = null;
    private volatile static Logger logger;

    private Logger() {
        filename = PathFinder.getFilename(Logger.class, SRC, LOG_TXT);
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


    @Override
    public void error(String message) {
        log("ERROR: " + message);
    }

    @Override
    public void info(String message) {
        log("INFO:  " + message);
    }

    private void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
