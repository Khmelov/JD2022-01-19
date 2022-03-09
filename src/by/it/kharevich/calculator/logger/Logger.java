package by.it.kharevich.calculator.logger;

import by.it.kharevich.calculator.utils.PathFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger implements Log {

    public static String filename = null;
    public static final String ROOT = "src";
    public static final String FILENAME = "log.txt";
    private volatile static Logger logger;

    private Logger() {
        filename = PathFinder.getFilename(Logger.class, ROOT, FILENAME);
    }
    public static Logger getInstance(){
        Logger localInstance = logger;
        if (Objects.isNull(localInstance)){
            synchronized (Logger.class){
                localInstance = logger;
                if (Objects.isNull(localInstance)) {
                    logger = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void error(String message) {
        log("ERROR0: " + message);
    }

    @Override
    public void info(String message) {
        log("INFO: " + message);
    }

    private void log(String message){
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))){
            out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
