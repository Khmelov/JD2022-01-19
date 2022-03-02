package by.it.kharevich.jd01_15;

import java.io.File;

public class PackageFinder {

    public static final String USER_DIR = "user.dir";
    public static final String DOT = ".";
    public static final String SRC = "src";

    public static String getPackage(Class<?> cClass, String startPackage) {
        return System.getProperty(USER_DIR) + File.separator + SRC + File.separator +
                cClass.getPackageName().replace(DOT,File.separator)+
                File.separator;
    }
}
