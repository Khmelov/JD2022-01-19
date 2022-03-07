package by.it.tarend.jd02_05;

import by.it.tarend.jd02_05.costants.Message;
import by.it.tarend.jd02_05.costants.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Task0205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResourceManager lang = ResourceManager.INSTANCE;
        Locale locale;
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
            lang.set(locale);
        } else {
            System.out.println("Choose lang(ru, be, en) :");
            String langSignature = sc.nextLine();
            switch (langSignature) {
                case "ru" -> lang.set(locale = new Locale("ru", "RU"));
                case "be" -> lang.set(locale = new Locale("be", "BY"));
                default -> lang.set(locale = new Locale("en", "EN"));
            }
        }
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy\tHH:mm:ss").localizedBy(locale);
        String formattedCurrentDate = currentDate.format(dateTimeFormatter);

        System.out.printf("%s\n%s\n%s %s %s\n%s:\n%s\n",
                lang.get(Message.WELCOME),
                lang.get(Message.QUESTION),
                lang.get(User.INFO),
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME),
                lang.get(Message.DATE),
                formattedCurrentDate
        );

    }

}
