package com.travel.travelAgency.commissions.models;


public class Commission {

    private String userId;
    private String dateTime;
    private float ticketAmount;
    private double commissionAmount;

    public String getuserId() {
        return userId;
    }

    public void setDateTime(String userId) {
        this.dateTime = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public float getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(float ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }
}
