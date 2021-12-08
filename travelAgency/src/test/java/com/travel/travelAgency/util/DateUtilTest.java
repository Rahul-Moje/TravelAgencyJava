package com.travel.travelAgency.util;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author rahulmoje
 */
public class DateUtilTest {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    public void testCalculateStartOfDay() throws ParseException {
        Date date = SIMPLE_DATE_FORMAT.parse("2021/12/01 12:47:42");
        Date expected = DateUtil.calculateStartOfDay(date);
        Assert.assertEquals("2021/12/01 00:00:00", SIMPLE_DATE_FORMAT.format(expected));

    }

    @Test
    public void testCalculateEndOfDay() throws ParseException {
        Date date = SIMPLE_DATE_FORMAT.parse("2021/12/01 12:47:42");
        Date expected = DateUtil.calculateEndOfDay(date);
        Assert.assertEquals("2021/12/01 23:59:59", SIMPLE_DATE_FORMAT.format(expected));
    }

    @Test
    public void testCalculateNumberOfDaysFromToday() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 7);
        int actualDays = DateUtil.calculateNumberOfDaysFromToday(calendar.getTime());
        Assert.assertEquals(7, actualDays);
    }

}
