package by.it.zaretskaya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String baseName="by.it.zaretskaya.jd02_05.resources.language";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName);
        Locale locale = new Locale("be","BY");
        System.out.printf("%s\n%s\n%s %s %s\n",
        resourceBundle.getString("messages.welcome"),
        resourceBundle.getString("messages.question"),
        resourceBundle.getString("user.info"),
        resourceBundle.getString("user.firstname"),
        resourceBundle.getString("user.lastname")
        );

    }
}
