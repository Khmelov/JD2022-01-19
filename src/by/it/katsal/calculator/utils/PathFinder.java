package by.it.katsal.calculator.utils;

import java.io.File;

public class PathFinder {

    private PathFinder() {
    }

    public static final String USER_DIR = "user.dir";
    public static final String DOT = ".";

    public static String getFilename(Class<?> aClass, String root, String filename) {
        return System.getProperty(USER_DIR) +
                File.separator + root + File.separator +
                aClass.getPackageName().replace(DOT, File.separator) +
                File.separator +
                filename;
    }
}
