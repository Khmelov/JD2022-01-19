package by.it.chaikova.jd02_06;

import java.io.File;

public class PathFinder {

    public static final String USER_DIR = "user.dir";
    public static final String ROOT = ".";

    public static String getFilename(Class<?> aClass, String root, String filename) {
       return System.getProperty(USER_DIR)+ File.separator+ root+File.separator+
                aClass.getPackageName().replace(ROOT,File.separator)+
                File.separator+
                filename;
    }
}
