package by.it.yushkevich.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    public static final String ROOT = "src";
    public static final String DOT = ".";
    public static final String USER_DIR = "user.dir";
    public static final String SEPARATOR = File.separator;
    public static final String NAME_TXT = "resultTaskC.txt";


    public static void main(String[] args) {

        String filePath = getNameFile(TaskC.class);
        System.out.println(filePath);

        File parentFile = getParentFile(filePath);
        String nameTxtFile = PathFinder.getFileName(TaskC.class, ROOT, NAME_TXT);
        printOutToConsole(parentFile, nameTxtFile);


    }

    private static File getParentFile(String filePath) {
        File buffFile = new File(filePath);
        File parentFile = new File(buffFile.getParent());
        return parentFile;
    }


    private static void printOutToConsole(File parentName, String txtNameFile) {
       try(
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtNameFile))
       ){ File[] files = parentName.listFiles();
           for (File file : files) {
               if (file.isDirectory()) {
                   writer.write("dir:"+file.getName());   //writer.write( String.format("dir:%s%n", file.getName()))
                   writer.newLine();
                   System.out.printf("dir:%s%n",file.getName());
                   for (File listFile : file.listFiles()) {
                       if (listFile.isFile()) {
                           writer.write("file:"+listFile.getName());
                           writer.newLine();
                           System.out.printf("file:%s%n",listFile.getName());
                       } else {
                           writer.write("dir:"+listFile.getName());
                           writer.newLine();
                           System.out.printf("dir:%s%n",listFile.getName());
                       }
                   }
               } else {
                   writer.write("file:"+file.getName());
                   writer.newLine();
                   System.out.printf("file:%s%n",file.getName());
               }
           }

       } catch (IOException e) {
           throw new RuntimeException("IO exception", e);
       }

    }

//    private static String getParentName(String nameFile) {
//        File file = new File(nameFile);
//        String parentName = file.getParent();
//
//        return parentName;
//
//    }


    private static String getNameFile(Class<TaskC> cClass) {

        String fileName = System.getProperty(USER_DIR) + SEPARATOR + ROOT +
                SEPARATOR + cClass.getPackageName().replace(TaskC.DOT, "\\");

        return fileName;
    }


}
