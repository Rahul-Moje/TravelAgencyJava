package com.travel.travelAgency.userprofile.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author rahulmoje
 */
@SpringBootTest
public class UserProfileControllerTest {

    @Autowired
    private UserProfileController userProfileController;

    @Mock
    private ModelMap modelMap;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletResponse httpServletResponse;

    @Test
    public void testCheckUserProfileControllerExists() {
        assertNotNull(userProfileController);
    }






}
