package com.travel.travelAgency.userprofile.controller;

import com.travel.travelAgency.userprofile.interfaces.UserProfileInterface;
import com.travel.travelAgency.userprofile.model.User;
import com.travel.travelAgency.userprofile.model.UserBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
@Controller
public class UserProfileController {

    @Autowired
    private UserProfileInterface userProfileInterface;

    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public String displayUserProfile(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        try{
            response.setContentType("text/html");
            User user = retrieveUserDetail(request);
            List<UserBooking> userBookings = retrieveUserBookings(request);
            modelMap.put("user", user);
            modelMap.put("userBookings", userBookings);
            return "userProfile";
        } catch (SQLException e) {
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", "Error occurred during database processes");
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", "Error occurred. Check logs");
            return "error";
        }
    }

    private List<UserBooking> retrieveUserBookings(HttpServletRequest request) throws SQLException {
        return userProfileInterface.retrieveUserBookings((String) request.getSession().getAttribute("email"));
    }

    private User retrieveUserDetail(HttpServletRequest request) throws SQLException {
        return userProfileInterface.retrieveUserDetail((String) request.getSession().getAttribute("email"));
    }
}
