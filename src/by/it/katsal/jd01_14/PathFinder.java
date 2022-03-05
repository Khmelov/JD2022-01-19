package by.it.katsal.jd01_14;
import java.io.File;

public class PathFinder {
    public static final String USER_DIRO = "user.dir" ;
    public static final String DOT = ".";

    public static String getFilename (Class<?> aClass, String root, String filename) {
        return System.getProperty(USER_DIRO ) +
               File.separator + root + File.separator +
               aClass.getPackageName().replace(DOT , File.separator ) +
               File.separator + filename ;
    }

}

