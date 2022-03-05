package by.it.yushkevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {

        Class<?> structure = Math.class;



        Method[] declaredMethods = structure.getDeclaredMethods();
        printOutOublicMethods(declaredMethods);

        Field[] fields = structure.getFields();
        printOutFields(fields);


    }

    private static void printOutFields(Field[] fields) {
        for (Field field : fields) {
            StringBuilder builder = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                builder.append("public ");
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                builder.append("static ");
            }
            if (Modifier.isPrivate(modifiers)) {
                builder.append("private ");
            }
            builder.append(field.getType().getSimpleName()).append(" ");
            builder.append(field.getName()).append('(');



            builder.append(field.getType().getSimpleName()).append(" ");
            builder.append(field.getName());
            builder.append(')');
            System.out.println(builder);

        }
    }

    private static void printOutOublicMethods(Method[] declaredMethods) {
        for (Method method : declaredMethods) {
            StringBuilder outLine = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                outLine.append("public ");
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                outLine.append("static ");
            }
            if (Modifier.isPrivate(modifiers)) {
                outLine.append("private ");
            }

            outLine.append(method.getReturnType().getSimpleName()).append(" ");
            outLine.append(method.getName()).append('(');

            String delimiter = "";
            Class<?>[] parameters = method.getParameterTypes();
            for (Class<?> parameter : parameters) {
                outLine.append(delimiter).append(parameter.getSimpleName());
                delimiter = ",";
            }
            outLine.append(')');
            System.out.println(outLine);

        }
    }
}
