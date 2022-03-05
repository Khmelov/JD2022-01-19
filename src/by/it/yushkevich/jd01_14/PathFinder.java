package by.it.yushkevich.jd01_14;

import java.io.File;

public class PathFinder {

    public static final String USER_DIR = "user.dir";
    public static final String DOT = ".";

    public static String getFileName(Class<?> aClass, String root, String fileName) {
        //получаем полный путь к файлу
//        String userDir = System.getProperty("user.dir");
//        String fullRootDir = userDir + File.separator + root + File.separator;
//        String packageName = aClass.getPackageName();
//        packageName = packageName.replace(".", File.separator);

        fileName = System.getProperty(USER_DIR) +
                File.separator + root + File.separator +
                aClass.getPackageName().replace(DOT, File.separator) +
                File.separator + fileName;


        return fileName;
    }
}
