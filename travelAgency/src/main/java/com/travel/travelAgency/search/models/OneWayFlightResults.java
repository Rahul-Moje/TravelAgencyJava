package com.travel.travelAgency.search.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rahulmoje
 */
public class OneWayFlightResults {

    private String flightCode;

    private String airLine;

    private Integer flightScheduleId;

    private String source;

    private String destination;

    private Date departureTime;

    private Date arrivalTime;

    private Long totalHours;

    private BigDecimal ticketPrice;

    private Integer seatsBooked;

    private Integer capacity;

    public void increaseFare(Integer percentage) {
        BigDecimal baseFare = this.ticketPrice;
        BigDecimal amountToAdd = baseFare.multiply(new BigDecimal(percentage).divide(new BigDecimal(100)));
        this.ticketPrice = baseFare.add(amountToAdd);
    }

    @Override
    public String toString() {
        return "OneWayFlightResults{" +
                "flightCode='" + flightCode + '\'' +
                ", airLine='" + airLine + '\'' +
                ", flightScheduleId=" + flightScheduleId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", totalHours=" + totalHours +
                ", ticketPrice=" + ticketPrice +
                ", seatsBooked=" + seatsBooked +
                ", capacity=" + capacity +
                '}';
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public Integer getFlightScheduleId() {
        return flightScheduleId;
    }

    public void setFlightScheduleId(Integer flightScheduleId) {
        this.flightScheduleId = flightScheduleId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Long totalHours) {
        this.totalHours = totalHours;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(Integer seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
