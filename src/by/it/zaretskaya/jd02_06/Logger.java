package by.it.zaretskaya.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static java.lang.System.out;

public class Logger implements Log {
    public static String filename=null;
    public static final String SRC = "src";
    public static final String LOG_TXT = "log.txt";
    private static Logger logger;


    private Logger() {
        filename=PathFinder.getFileName(Logger.class, SRC, LOG_TXT);
    }
    public static Logger getInstance(){
        Logger LocalInstance= logger;
        if(Objects.isNull(LocalInstance)){
            synchronized (Logger.class){
                 LocalInstance=logger;
                 if (Objects.isNull(LocalInstance)){
                      LocalInstance=new Logger();
                     logger= LocalInstance;

                 }

            }
        }
        return LocalInstance;
    }

    @Override
    public void error(String message) {
      log("ERROR: "+message);
    }

    @Override
    public void info(String message) {
     log("INFO: "+message);
    }

    private void log(String message){
     try( PrintWriter out=new PrintWriter (new FileWriter(filename,true))) {
         out.println(message);
     }catch (IOException e){
         throw new RuntimeException(e);
     };
    }
}
