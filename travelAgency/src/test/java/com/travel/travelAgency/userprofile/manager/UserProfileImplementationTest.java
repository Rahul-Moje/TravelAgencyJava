package com.travel.travelAgency.userprofile.manager;

import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.userprofile.interfaces.UserProfileInterface;
import com.travel.travelAgency.userprofile.model.*;
import com.travel.travelAgency.userprofile.repository.UserProfileRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rahulmoje
 */
@RunWith(MockitoJUnitRunner.class)
public class UserProfileImplementationTest {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileInterface userProfileInterface = new UserProfileImplementation();

    @Test
    public void testRetrieveUserDetail() throws SQLException {
        User expectedUser = buildUserForTest();
        Mockito.when(userProfileRepository.retrieveUserDetail("user1@test.com")).thenReturn(expectedUser);
        User actualUser = userProfileInterface.retrieveUserDetail("user1@test.com");
        Assert.assertNotNull(actualUser);
        Assert.assertEquals(expectedUser.getUserName(), actualUser.getUserName());
        Assert.assertEquals(expectedUser.getUserEmail(), actualUser.getUserEmail());
        Assert.assertEquals(((ProMember)expectedUser).getDateOfPurchase(), ((ProMember)actualUser).getDateOfPurchase());
        Assert.assertEquals(((ProMember)expectedUser).getDateOfPurchase(), ((ProMember)actualUser).getDateOfPurchase());
    }

    @Test
    public void testRetrieveUserBookings() throws ParseException, SQLException {
        List<UserBooking> expectedBookings = buildBookingsForTest();
        Mockito.when(userProfileRepository.retrieveUserBookings("user1@test.com")).thenReturn(expectedBookings);
        List<UserBooking> actualBookings = userProfileInterface.retrieveUserBookings("user1@test.com");
        Assert.assertNotNull(actualBookings);
        Assert.assertFalse(actualBookings.isEmpty());
        Assert.assertEquals(expectedBookings.size(), actualBookings.size());
        for(int i=0;i<actualBookings.size();i++) {
            Assert.assertEquals(expectedBookings.get(0).getBookingId(), actualBookings.get(0).getBookingId());
            Assert.assertEquals(UserBookingStatus.COMPLETED, actualBookings.get(i).getUserBookingStatus());
        }

    }

    private List<UserBooking> buildBookingsForTest() throws ParseException {
        List<UserBooking> bookings = new ArrayList<>();
        UserBooking booking = new UserBooking.UserBookingBuilder(1)
                .withBookingDate(DATE_FORMATTER.parse("2021-12-01 00:00:00"))
                .withSource("BOM")
                .withDestination("YYZ")
                .withFromDate(DATE_FORMATTER.parse("2021-12-02 00:00:00"))
                .withCancelled(false)
                .withJourneyType(JourneyType.ONE_WAY)
                .withFinalCost(new BigDecimal("250000"))
                .build();
        bookings.add(booking);
        return bookings;
    }

    private User buildUserForTest() {
        return new ProMember.ProMemberBuilder()
                .withUserName("user1")
                .withUserEmail("user1@test.com")
                .withPlanName(PlanName.GOLD)
                .withDateOfPurchase(new Date())
                .build();
    }
}
