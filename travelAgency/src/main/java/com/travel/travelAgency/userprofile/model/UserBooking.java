package com.travel.travelAgency.userprofile.model;

import com.travel.travelAgency.search.models.JourneyType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rahulmoje
 */
public class UserBooking {

    private static final Date TODAYS_DATE = new Date();

    private Integer bookingId;

    private Date bookingDate;

    private UserBookingStatus userBookingStatus;

    private String source;

    private String destination;

    private JourneyType journeyType;

    private String fromFlightCode;

    private Date fromDate;

    private String toFlightCode;

    private Date toDate;

    private BigDecimal finalCost;

    private boolean cancelled;

    public boolean isNotCancelled() {
        return !cancelled;
    }

    public void findAndSetStatusForOneWayBooking() {
        checkAndSetCancelledBooking();
        checkAndSetUpcomingBooking();
        checkAndSetCompletedBooking(this.fromDate);
    }

    public void findAndSetStatusForReturnBooking() {
        checkAndSetCancelledBooking();
        checkAndSetUpcomingBooking();
        checkAndSetOngoingReturnBooking();
        checkAndSetCompletedBooking(this.toDate);
    }

    private void checkAndSetCompletedBooking(Date date) {
        if(isNotCancelled() && TODAYS_DATE.compareTo(date) >= 0) {
            this.userBookingStatus = UserBookingStatus.COMPLETED;
        }
    }

    private void checkAndSetOngoingReturnBooking() {
        if(isNotCancelled() && TODAYS_DATE.compareTo(fromDate) >= 0 && TODAYS_DATE.compareTo(toDate) <= 0) {
            this.userBookingStatus = UserBookingStatus.ONGOING;
        }
    }

    private void checkAndSetUpcomingBooking() {
        if(isNotCancelled() && TODAYS_DATE.compareTo(fromDate) < 0) {
            this.userBookingStatus = UserBookingStatus.UPCOMING;
        }
    }

    private void checkAndSetCancelledBooking() {
        if(cancelled) {
            this.userBookingStatus = UserBookingStatus.CANCELLED;
        }
    }


    @Override
    public String toString() {
        return "UserBooking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", userBookingStatus=" + userBookingStatus +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", journeyType=" + journeyType +
                ", fromFlightCode='" + fromFlightCode + '\'' +
                ", fromDate=" + fromDate +
                ", toFlightCode='" + toFlightCode + '\'' +
                ", toDate=" + toDate +
                ", finalCost=" + finalCost +
                ", cancelled=" + cancelled +
                '}';
    }

    private UserBooking() {
    }

    private UserBooking(UserBookingBuilder userBookingBuilder) {
        bookingId = userBookingBuilder.bookingId;
        bookingDate = userBookingBuilder.bookingDate;
        source = userBookingBuilder.source;
        destination = userBookingBuilder.destination;
        journeyType = userBookingBuilder.journeyType;
        fromFlightCode = userBookingBuilder.fromFlightCode;
        fromDate = userBookingBuilder.fromDate;
        toFlightCode = userBookingBuilder.toFlightCode;
        toDate = userBookingBuilder.toDate;
        finalCost = userBookingBuilder.finalCost;
        cancelled = userBookingBuilder.cancelled;
    }

    public static class UserBookingBuilder {

        private Integer bookingId;

        private Date bookingDate;

        private String source;

        private String destination;

        private JourneyType journeyType;

        private String fromFlightCode;

        private Date fromDate;

        private String toFlightCode;

        private Date toDate;

        private BigDecimal finalCost;

        private boolean cancelled;

        public UserBookingBuilder(Integer bookingId) {
            this.bookingId = bookingId;
        }

        public UserBookingBuilder withBookingDate(Date bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public UserBookingBuilder withSource(String source) {
            this.source = source;
            return this;
        }

        public UserBookingBuilder withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public UserBookingBuilder withJourneyType(JourneyType journeyType) {
            this.journeyType = journeyType;
            return this;
        }

        public UserBookingBuilder withFromFlightCode(String fromFlightCode) {
            this.fromFlightCode = fromFlightCode;
            return this;
        }

        public UserBookingBuilder withFromDate(Date fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public UserBookingBuilder withToFlightCode(String toFlightCode) {
            this.toFlightCode = toFlightCode;
            return this;
        }

        public UserBookingBuilder withToDate(Date toDate) {
            this.toDate = toDate;
            return this;
        }

        public UserBookingBuilder withFinalCost(BigDecimal finalCost) {
            this.finalCost = finalCost;
            return this;
        }

        public UserBookingBuilder withCancelled(Boolean cancelled) {
            this.cancelled = cancelled;
            return this;
        }

        public UserBooking build() {
            return new UserBooking(this);
        }

    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public UserBookingStatus getUserBookingStatus() {
        return userBookingStatus;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public String getFromFlightCode() {
        return fromFlightCode;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public String getToFlightCode() {
        return toFlightCode;
    }

    public Date getToDate() {
        return toDate;
    }

    public BigDecimal getFinalCost() {
        return finalCost;
    }
}
