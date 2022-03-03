package by.it.burov.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import static java.io.File.separator;

public class TaskC {

    private static final String ROOT = "src";

    public static void main(String[] args) {
        String path = PathFinder.getFilename(TaskC.class, ROOT);
        String command;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                File file = new File(path);
                System.out.println(path);
                command = reader.readLine();
                if (command.equals("cd..")) {
                    path = path.substring(0, path.lastIndexOf(separator));

                    if (path.length() == 2) {
                        path += separator;
                    }
                } else if (command.equals("dir")) {
                    openFile(file);
                } else if (command.contains("cd ")) {
                    path = path + separator + command.substring(3) + separator;
                } else if (command.equals("end")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openFile(File file) {
        File[] files = file.listFiles();

        assert files != null;
        for (File value : files) {
            try {
                String lastModified = String.valueOf(Files.getLastModifiedTime(file.toPath())).
                        substring(0,16).
                        replace("T"," ");
                System.out.printf("%-16s %-6s %-6d %s%n",
                        lastModified,
                        (Files.isDirectory(file.toPath())) ? "<DIR>" : "<FILE>",
                        Files.size(file.toPath()),
                        value.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
