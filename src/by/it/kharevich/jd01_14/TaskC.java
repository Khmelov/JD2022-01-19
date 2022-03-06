package by.it.kharevich.jd01_14;


import java.io.File;

public class TaskC {

    public static final String TXT = "resultTaskC.txt";
    public static final String ROOT = "src";
    public static final String BY_IT_KHAREVICH = "D:\\IT\\Homework\\GithubProject\\src\\by\\it\\kharevich\\";

    public static void main(String[] args) {
        String fileName = PathFinder.getFilename2(TaskC.class, ROOT);
        System.out.println(fileName);

        File dir = new File(BY_IT_KHAREVICH);
        File[] dirFiles = dir.listFiles();
        for (int j = 0; j < dirFiles.length; j++) {
            File file = dirFiles[j];
            System.out.println("dir:" + file.getName());
        /*    File name = new File(fileName);
            File[] nameFiles = name.listFiles();
            for (int i = 0; i < nameFiles.length; i++) {
                File file1 = dirFiles[i];
                System.out.printf("file:%s%n", file1.list());
            }*/
        }
    }
}
