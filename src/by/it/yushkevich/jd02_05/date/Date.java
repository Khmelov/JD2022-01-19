package by.it.yushkevich.jd02_05.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date {

    public static void main(String[] args) {
        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(localTime);

        Instant gmt = Instant.now();
        System.out.println(gmt);


        ZoneId minsk = ZoneId.of("UTC+3");
        ZonedDateTime fullTime = ZonedDateTime.of(localTime, minsk);
        System.out.println(fullTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String format = fullTime.format(formatter);
        System.out.println(format);


    }
}
