package pl.dmichalski.reservations.business.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

}
