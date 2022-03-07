package by.it.katsal.jd01_10;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {


        Class<Math> structure = Math.class;


        Field[] fields = structure.getFields();
        Method[] declaredMethods = structure.getDeclaredMethods();

        for (Field field : fields) {
            StringBuilder outField = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                outField.append("public ");
            }
            else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                outField.append("static ");
            }

            else {
                continue;
            }
            outField.append(field.getType().getSimpleName()).append(" ");
            outField.append(field.getName());
            System.out.println(outField);

        }

        System.out.println("-".repeat(40));

        for (Method method : declaredMethods) {
            StringBuilder outMethod = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                outMethod.append("public ");
            }

            else {
                continue;
            }
            if (Modifier.isStatic(modifiers)){
                outMethod.append("static ");
            }

            else {
                continue;
            }
            outMethod.append(method.getReturnType().getSimpleName()).append(" ");
            outMethod.append(method.getName()).append('(');
            String delimiter = "";
            Class<?>[] parameters = method.getParameterTypes();
            for (Class<?> parameter : parameters) {
                outMethod.append(delimiter).append(parameter.getSimpleName());
                delimiter = ",";
            }
            outMethod.append(')');

            System.out.println(outMethod);
        }
    }
}



