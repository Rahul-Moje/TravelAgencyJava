package com.travel.travelAgency.userprofile.model;

/**
 * @author rahulmoje
 */
public enum UserBookingStatus {

    UPCOMING("Upcoming"),
    ONGOING("Ongoing"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private String description;

    UserBookingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
