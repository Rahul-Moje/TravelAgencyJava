package com.travel.travelAgency.bookings.model;

import com.travel.travelAgency.search.models.JourneyType;

import java.math.BigDecimal;

/**
 * @author rahulmoje
 */
public class FlightBookingRequest {

    private JourneyType journeyType;

    private Integer toFlightScheduleId;

    private Integer fromFlightScheduleId;

    private String userName;

    private String userEmail;

    private Integer numOfBaggages;

    private MealType mealType;

    private Integer numOfPassengers;

    private BigDecimal totalCost;

    private FlightBookingRequest() {

    }

    private FlightBookingRequest(FlightBookingRequestBuilder flightBookingRequestBuilder) {
        this.journeyType = flightBookingRequestBuilder.journeyType;
        this.toFlightScheduleId = flightBookingRequestBuilder.toFlightScheduleId;
        this.fromFlightScheduleId = flightBookingRequestBuilder.fromFlightScheduleId;
        this.userName = flightBookingRequestBuilder.userName;
        this.userEmail = flightBookingRequestBuilder.userEmail;
        this.numOfBaggages = flightBookingRequestBuilder.numOfBaggages;
        this.mealType = flightBookingRequestBuilder.mealType;
        this.numOfPassengers = flightBookingRequestBuilder.numOfPassengers;
        this.totalCost = flightBookingRequestBuilder.totalCost;
    }

    public boolean isReturnJourney() {
        return this.getJourneyType() == JourneyType.RETURN;
    }

    @Override
    public String toString() {
        return "FlightBookingRequest{" +
                "journeyType=" + journeyType +
                ", toFlightScheduleId=" + toFlightScheduleId +
                ", fromFlightScheduleId=" + fromFlightScheduleId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", numOfBaggages=" + numOfBaggages +
                ", mealType=" + mealType +
                ", numOfPassengers=" + numOfPassengers +
                ", totalCost=" + totalCost +
                '}';
    }

    public static class FlightBookingRequestBuilder {

        private JourneyType journeyType;

        private Integer toFlightScheduleId;

        private Integer fromFlightScheduleId;

        private String userName;

        private String userEmail;

        private Integer numOfBaggages;

        private MealType mealType;

        private Integer numOfPassengers;

        private BigDecimal totalCost;

        @Override
        public String toString() {
            return "FlightBookingRequestBuilder{" +
                    "journeyType=" + journeyType +
                    ", toFlightScheduleId=" + toFlightScheduleId +
                    ", fromFlightScheduleId=" + fromFlightScheduleId +
                    ", userName='" + userName + '\'' +
                    ", userEmail='" + userEmail + '\'' +
                    ", numOfBaggages=" + numOfBaggages +
                    ", mealType=" + mealType +
                    ", numOfPassengers=" + numOfPassengers +
                    ", totalCost=" + totalCost +
                    '}';
        }

        public FlightBookingRequestBuilder() {

        }

        public FlightBookingRequestBuilder withJourneyType(JourneyType journeyType) {
            this.journeyType = journeyType;
            return this;
        }

        public FlightBookingRequestBuilder withToFlightScheduleId(Integer toFlightScheduleId) {
            this.toFlightScheduleId = toFlightScheduleId;
            return this;
        }

        public FlightBookingRequestBuilder withFromFlightScheduleId(Integer fromFlightScheduleId) {
            this.fromFlightScheduleId = fromFlightScheduleId;
            return this;
        }

        public FlightBookingRequestBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public FlightBookingRequestBuilder withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public FlightBookingRequestBuilder withNumOfBaggages(Integer numOfBaggages) {
            this.numOfBaggages = numOfBaggages;
            return this;
        }

        public FlightBookingRequestBuilder withMealType(MealType mealType) {
            this.mealType = mealType;
            return this;
        }

        public FlightBookingRequestBuilder withNumOfPassengers(Integer numOfPassengers) {
            this.numOfPassengers = numOfPassengers;
            return this;
        }

        public FlightBookingRequestBuilder withTotalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public FlightBookingRequest build() {
            return new FlightBookingRequest(this);
        }
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public Integer getToFlightScheduleId() {
        return toFlightScheduleId;
    }

    public Integer getFromFlightScheduleId() {
        return fromFlightScheduleId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Integer getNumOfBaggages() {
        return numOfBaggages;
    }

    public MealType getMealType() {
        return mealType;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
}
