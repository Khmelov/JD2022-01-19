package by.it.kharevich.jd02_05.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OldDate {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.MARCH,5);
        Date calendarTime = calendar.getTime();
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println(calendarTime);
        System.out.println(timeInMillis);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yy");
        String format = simpleDateFormat.format(calendarTime);
        System.out.println(format);
    }
}
