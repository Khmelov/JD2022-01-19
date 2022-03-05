package by.it.katsal.jd01_13;
import java.util.HashMap;
public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String ,String >(null );
            else
                Integer.parseInt("привет");
        }catch (NullPointerException | NumberFormatException e){
            printException(e);
        }
    }

    private static void printException(RuntimeException e) {
        Class <? extends RuntimeException > eClass = e.getClass();
        String eClassName = eClass.getName();
        Class <TaskA> taskAClass = TaskA.class;
        String aClassName = taskAClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace ){
            String className = stackTraceElement.getClassName();
            if (aClassName.equals(className)){
                int lineNamber = stackTraceElement.getLineNumber();
                System.out.printf(
                        " name: %sn\n" + "class: %s\n "+ "line: %d\n",eClassName , className, lineNamber);
                break;
            }
        }




    }


}


