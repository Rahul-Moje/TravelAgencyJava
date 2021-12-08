package com.travel.travelAgency.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author rahulmoje
 */
public final class DateUtil {

    private DateUtil() {
        throw new RuntimeException("Utility classes should not be instantiated");
    }

    public static Date calculateStartOfDay(Date inputDate) {
        Calendar endOfDayCalender = Calendar.getInstance();
        endOfDayCalender.setTime(inputDate);
        endOfDayCalender.set(Calendar.SECOND, 0);
        endOfDayCalender.set(Calendar.MINUTE, 0);
        endOfDayCalender.set(Calendar.HOUR_OF_DAY, 0);
        return endOfDayCalender.getTime();
    }

    public static Date calculateEndOfDay(Date inputDate) {
        Calendar endOfDayCalender = Calendar.getInstance();
        endOfDayCalender.setTime(inputDate);
        endOfDayCalender.set(Calendar.SECOND, 59);
        endOfDayCalender.set(Calendar.MINUTE, 59);
        endOfDayCalender.set(Calendar.HOUR_OF_DAY, 23);
        return endOfDayCalender.getTime();
    }

    public static Integer calculateNumberOfDaysFromToday(Date endDate) {
        Date todaysDate = calculateStartOfDay(new Date());
        endDate = calculateStartOfDay(endDate);
        long difference = endDate.getTime() - todaysDate.getTime();
        long numberOfDays = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        return (int) numberOfDays;
    }
}
