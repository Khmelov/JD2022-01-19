package by.it.kharevich.jd02_05.date;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NewDate {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("-----------------------------------------------------");

        Instant instantGreenwich = Instant.now();
        System.out.println(instantGreenwich);
        System.out.println("-----------------------------------------------------");

        ZoneId zoneIdMinsk = ZoneId.of("UTC+3");
        ZonedDateTime zonedDateTimeMinsk = ZonedDateTime.ofInstant(instantGreenwich, zoneIdMinsk);
        System.out.println(zonedDateTimeMinsk);
        System.out.println("-----------------------------------------------------");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("--- dd MMMM yyyy --- HH:mm:ss ---");
        String format = zonedDateTimeMinsk.format(dateTimeFormatter);
        System.out.println(format);
        System.out.println("-----------------------------------------------------");
        


    }


}
