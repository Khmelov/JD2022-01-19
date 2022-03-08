package by.it.zaretskaya.jd02_05;

import java.util.ResourceBundle;

public class TaskA {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.zaretskaya.jd02_05.resources.language");
        System.out.printf("%s\n%s\n%s %s %s\n",
        resourceBundle.getString("messages.welcome"),
        resourceBundle.getString("messages.question"),
        resourceBundle.getString("user.info"),
        resourceBundle.getString("user.firstname"),
        resourceBundle.getString("user.lastname")
        );

    }
}
