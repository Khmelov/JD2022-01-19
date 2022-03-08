package by.it.burov.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger implements Log{

    public static final String ROOT = "src";
    public static final String LOG_TXT = "log.txt";
    private static String filename;
    private volatile static Logger logger;

    private Logger() {
        filename = PathFinder.getFilename(Logger.class, ROOT, LOG_TXT);
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
    private void log(String message){
        try(PrintWriter out = new PrintWriter(new FileWriter(filename,true))){
            out.println(message);
        }catch (IOException e){
           throw new RuntimeException(e);
        }
    }

    @Override
    public void error(String messages) {
        log("ERROR " + messages);

    }

    @Override
    public void info(String messages) {
        log("INFO " + messages);
    }
}
