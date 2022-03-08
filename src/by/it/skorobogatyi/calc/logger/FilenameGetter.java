package by.it.skorobogatyi.calc.logger;

import static java.io.File.separator;


public class FilenameGetter {

    private static final String DOT = ".";
    public static final String USER_DIR = "user.dir";


    public static String getFilename(Class<?> aClass, String root, String filename) {
        String userDir = System.getProperty(USER_DIR);
        String fullRootDir = userDir + separator + root + separator;
        String returnString = aClass.getPackageName().replace(DOT, separator);
        filename = returnString + separator + filename;
        return fullRootDir + filename;
    }
}
