package by.it.burov.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class TaskC {

    private static final String ROOT = "src";
    private static final String TXT = "resultTaskC.txt";

    public static void main(String[] args) throws IOException {
        String path = PathFinder.getFilename(TaskC.class, ROOT);
        System.out.println(path);
        File file = new File(path);
        String outFile = PathFinder.getFilename(TaskC.class, ROOT, TXT);
        File[] files = file.listFiles();
        outToConsoleAndTxt(files, outFile);
    }

    private static void outToConsoleAndTxt(File[] files, String outFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    System.out.printf("file:%s%n", files[i].getName());
                    writer.write(String.format("file:%s%n", files[i].getName()));
                } else {
                    System.out.printf("dir:%s%n", files[i].getName());
                    writer.write(String.format("dir:%s%n", files[i].getName()));
                    outToConsoleAndTxt(Objects.requireNonNull(files[i].listFiles()), outFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
