package com.travel.travelAgency.cancellations.controller;

import com.travel.travelAgency.cancellations.exceptions.BookingCancellationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author rahulmoje
 */
@SpringBootTest
public class BookingsCancellationControllerTest {

    @Autowired
    private BookingsCancellationController bookingsCancellationController;


    @Mock
    ModelMap modelMap;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletResponse httpServletResponse;

    @Test
    public void testFlightBookingControllerExists() {
        assertNotNull(bookingsCancellationController);
    }

    @Test
    public void testCancelBookingWhenAlreadyCancelled() {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setParameter("bookingId", "1");
        try {
            bookingsCancellationController.cancelBooking(modelMap, httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof BookingCancellationException);
        }
    }



    @Test
    public void testCancelBookingWhenNoBookingIdFound() {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setParameter("bookingId", "1");
        try {
            bookingsCancellationController.cancelBooking(modelMap, httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof BookingCancellationException);
        }
    }

}
