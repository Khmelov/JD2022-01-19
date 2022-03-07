package by.it.tarend.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {
    public static void main(String[] args) {
        String baseName = "by.it.tarend.jd02_05.resourses.language";
        Locale localeBY = new Locale("be");
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, localeBY);

        System.out.printf("%s\n%s\n%s %s %s\n",
                resourceBundle.getString("messages.welcome"),
                resourceBundle.getString("messages.question"),
                resourceBundle.getString("user.info"),
                resourceBundle.getString("user.firstname"),
                resourceBundle.getString("user.lastname")
        );
    }

}
