package by.it.tarend.jd02_06;

import java.io.File;

public class PathFinder {

    public static final String USER_DIR = "user.dir";
    public static final String DOT = ".";

    public static String getFileName(Class<?> aClass, String root, String fileName) {
//        String userDir = System.getProperty("user.dir"); // путь до src
//        String fullRoot = userDir + File.separator + root + File.separator; // путь с добавленным src ../src/
//        String packageName = aClass.getPackageName(); // получили наименование пакета в котором лежит передаваемый класс

        return System.getProperty(USER_DIR) +
                File.separator + root + File.separator +
                aClass.getPackageName().replace(DOT, File.separator) + // заменили точки на / и добавили имя файла = получили полный путь к файлу
                File.separator +
                fileName;

    }
}
