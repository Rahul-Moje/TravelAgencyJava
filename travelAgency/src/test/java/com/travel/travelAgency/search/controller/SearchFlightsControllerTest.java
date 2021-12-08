package com.travel.travelAgency.search.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author rahulmoje
 */
@SpringBootTest
public class SearchFlightsControllerTest {

    @Autowired
    private SearchFlightsController searchFlightsController;

    @Mock
    private ModelMap modelMap;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletResponse httpServletResponse;

    @Test
    public void testCheckSearchFlightsControllerExists() {
        assertNotNull(searchFlightsController);
    }

    @Test
    public void testInitialisePage() {
        String result = searchFlightsController.initialisePage(modelMap, httpServletRequest, httpServletResponse);
        assertNotNull(result);
        assertEquals("searchFlights", result);
    }
}
