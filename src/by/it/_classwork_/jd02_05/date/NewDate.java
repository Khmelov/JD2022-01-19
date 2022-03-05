package by.it._classwork_.jd02_05.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NewDate {
    public static void main(String[] args) {
        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(localTime);

        Instant gmt = Instant.now();
        System.out.println(gmt);

        ZoneId minsk = ZoneId.of("UTC+3");
        ZonedDateTime fullTime = ZonedDateTime.of(localTime, minsk);
        System.out.println(fullTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        String str = fullTime.format(dateTimeFormatter);
        System.out.println(str);
    }
}
