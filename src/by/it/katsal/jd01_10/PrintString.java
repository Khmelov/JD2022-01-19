package by.it.katsal.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            StringBuilder outLine = new StringBuilder();
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)){
                outLine.append(method.getName());
                System.out.println(outLine);
            }
        }

    }
}


