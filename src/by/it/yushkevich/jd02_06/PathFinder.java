package by.it.yushkevich.jd02_06;

import java.io.File;

public class PathFinder {

    public static final String USER_DIR = "user.dir";
    public static final String DOT = ".";

    public static String getFileName(Class<?> aClass, String root, String fileName) {

        fileName = System.getProperty(USER_DIR) +
                File.separator + root + File.separator +
                aClass.getPackageName().replace(DOT, File.separator) +
                File.separator + fileName;


        return fileName;
    }
}
