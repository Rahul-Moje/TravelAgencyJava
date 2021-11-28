package com.travel.travelAgency.bookings.model;

import com.travel.travelAgency.search.models.JourneyType;

public class FlightBookingRequest {

    private JourneyType journeyType;

    private Integer toFlightScheduleId;

    private Integer fromFlightScheduleId;

    private String userName;

    private Integer numOfBaggages;

    private MealType mealType;

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(JourneyType journeyType) {
        this.journeyType = journeyType;
    }

    public Integer getToFlightScheduleId() {
        return toFlightScheduleId;
    }

    public void setToFlightScheduleId(Integer toFlightScheduleId) {
        this.toFlightScheduleId = toFlightScheduleId;
    }

    public Integer getFromFlightScheduleId() {
        return fromFlightScheduleId;
    }

    public void setFromFlightScheduleId(Integer fromFlightScheduleId) {
        this.fromFlightScheduleId = fromFlightScheduleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNumOfBaggages() {
        return numOfBaggages;
    }

    public void setNumOfBaggages(Integer numOfBaggages) {
        this.numOfBaggages = numOfBaggages;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }
}
