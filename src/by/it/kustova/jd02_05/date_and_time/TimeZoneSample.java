package by.it.kustova.jd02_05.date_and_time;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneSample {
    public static void main(String[] args) {
        Calendar calendar= Calendar.getInstance();
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTimeZone().getDisplayName());
        calendar.set(1970,Calendar.JANUARY,1,0,0,0);
        Date moment= calendar.getTime();
        System.out.println("1. "+ moment.getTime()+ " или "+ moment);

        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTimeZone().getDisplayName());
        calendar.set(1970,Calendar.JANUARY,1,0,0,0);
        moment= calendar.getTime();

        System.out.println("2. "+ moment.getTime()+ " или "+ moment);
    }

}
