package com.danielmichalski.reservations.commons.date;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
class DateFormatterServiceImpl implements DateFormatterService {

    private static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return formatter.format(date);
    }

}
