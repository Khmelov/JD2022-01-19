package by.it.kuzma.jd01_15;

import by.it.kuzma.jd01_14.PathFinder;


/**
 * JavaDoc
 */

public class TaskB {

    public static final String ROOT = "src";
    public static final String TASK_B = "TaskB.java";

    public static void main(String[] args) {



        /* В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
    - Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
    - Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
    - Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.*/

        String filename = PathFinder.getFilename(TaskA.class, ROOT, TASK_B);

        System.out.println(filename);


    }


        }

