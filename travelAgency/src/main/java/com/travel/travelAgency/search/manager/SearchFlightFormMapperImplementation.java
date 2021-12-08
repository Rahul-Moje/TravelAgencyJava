package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.interfaces.SearchFlightFormMapperInterface;
import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.search.models.SearchFlightForm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author rahulmoje
 */
@Service
public class SearchFlightFormMapperImplementation implements SearchFlightFormMapperInterface {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public SearchFlightForm mapFormData(HttpServletRequest request) {
        try {
            SearchFlightForm.SearchFlightFormBuilder searchFlightFormBuilder =
                    new SearchFlightForm.SearchFlightFormBuilder(request.getParameter("sources"), request.getParameter("destinations"));
            searchFlightFormBuilder.withFromDate(DATE_FORMATTER.parse(request.getParameter("fromDate")));
            searchFlightFormBuilder.withToDate(DATE_FORMATTER.parse(request.getParameter("toDate")));
            searchFlightFormBuilder.withJourneyType(JourneyType.mapToJourneyType(request.getParameter("oneWayOrReturn")));
            searchFlightFormBuilder.withNumberOfPassengers(Integer.parseInt(request.getParameter("numPassengers")));
            return searchFlightFormBuilder.build();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new SearchFlightsException("Invalid date");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new SearchFlightsException("Invalid number of passengers");
        }
    }
}
