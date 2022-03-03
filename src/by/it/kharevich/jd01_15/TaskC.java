package by.it.kharevich.jd01_15;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {

    public static final String START_PACKAGE = "src";
    public static final String COMMAND_LINE = "cmd";
    public static final String CD = "cd";
    public static final String END = "end";
    public static final String DIR = "dir";
    public static final String BY = "by";
    public static final String DOT = ".";
    public static Scanner scanner = new Scanner(System.in);
    public static String consoleScanner;
    public static String startPackage = PackageFinder.getPackage(TaskC.class, START_PACKAGE);
    public static String endPackages = (BY + DOT + "it" + DOT + "kharevich" + DOT + "jd01_15");

    public static void main(String[] args) {
        System.out.println("Выполнить (введите 'cmd' чтобы открыть Командную строку):");
        extractedPackage();
    }


    private static void extractedPackage() {
        while (true) {
            consoleScanner = scanner.nextLine();
            if (consoleScanner.equals(COMMAND_LINE)) {
                System.out.println("Kharevich JavaHome [Version 1.0]");
                System.out.println("(c) Корпорация Харевич (Kharevich Corporation). Все права защищены.");
                System.out.println(endPackages);
                extractedCmd();
            } else if (consoleScanner.equals(END)) {
                break;
            } else {
                System.out.println("ERROR");
            }
        }
    }

    private static void extractedCmd() {
        while (true) {
            consoleScanner = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(consoleScanner);
            String result = String.valueOf(stringBuilder.delete(0, 2));

            if (consoleScanner.equals(END)) System.exit(0);
            else if (consoleScanner.equals(CD)) System.out.println(endPackages);
            else if (endPackages.contains(result)) System.out.println(result + DOT);
            else if (consoleScanner.equals(DIR)) {
                File dir = new File(startPackage);
                File[] dirFiles = dir.listFiles();
                for (File file : Objects.requireNonNull(dirFiles)) {
                    System.out.println("dir:" + file.getName());
                }
            }
        }
    }
}
