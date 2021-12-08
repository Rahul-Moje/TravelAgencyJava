package com.travel.travelAgency.search.util;

import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.search.models.SearchFlightForm;

import java.util.Calendar;
import java.util.Date;

/**
 * @author rahulmoje
 */
public final class TestDataUtil {

    private TestDataUtil() {
        throw new RuntimeException("Utility classes should not be instantiated");
    }

    public static SearchFlightForm buildFormForTest() {
        Date todaysDate = new Date();

        Calendar endDateCalendar = Calendar.getInstance();
        endDateCalendar.setTime(todaysDate);
        endDateCalendar.add(Calendar.DATE, 1);

        SearchFlightForm.SearchFlightFormBuilder searchFlightFormBuilder =
                new SearchFlightForm.SearchFlightFormBuilder("BOM", "YYZ");
        searchFlightFormBuilder.withFromDate(todaysDate);
        searchFlightFormBuilder.withToDate(endDateCalendar.getTime());
        searchFlightFormBuilder.withJourneyType(JourneyType.ONE_WAY);
        searchFlightFormBuilder.withNumberOfPassengers(2);
        return searchFlightFormBuilder.build();
    }
}
