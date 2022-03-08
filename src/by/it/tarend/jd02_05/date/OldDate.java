package by.it.tarend.jd02_05.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OldDate {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.MARCH, 7, 22, 30, 0);
        Date time = calendar.getTime();
        System.out.println(time);
        long millis = time.getTime();
        Date date1 = new Date(millis);
        System.out.println(date1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MMMM.yyyy HH.mm.ss");
        String formattedDate = simpleDateFormat.format(date1);
        System.out.println(formattedDate);
    }
}
