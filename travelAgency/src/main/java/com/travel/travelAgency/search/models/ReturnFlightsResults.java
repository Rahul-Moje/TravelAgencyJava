package com.travel.travelAgency.search.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rahulmoje
 */
public class ReturnFlightsResults {

    private String fromFlightCode;

    private String fromAirLine;

    private Integer fromFlightScheduleId;

    private String fromSource;

    private String fromDestination;

    private Date fromDepartureTime;

    private Date fromArrivalTime;

    private Long fromTotalHours;

    private BigDecimal fromTicketPrice;

    private Integer fromSeatsBooked;

    private Integer fromCapacity;

    private String toFlightCode;

    private String toAirLine;

    private Integer toFlightScheduleId;

    private String toSource;

    private String toDestination;

    private Date toDepartureTime;

    private Date toArrivalTime;

    private Long toTotalHours;

    private BigDecimal toTicketPrice;

    private Integer toSeatsBooked;

    private Integer toCapacity;

    private BigDecimal totalTicketPrice;

    public void increaseFare(Integer percentage) {
        BigDecimal baseFare = this.totalTicketPrice;
        BigDecimal amountToAdd = baseFare.multiply(new BigDecimal(percentage).divide(new BigDecimal(100)));
        this.totalTicketPrice = baseFare.add(amountToAdd);
    }

    @Override
    public String toString() {
        return "ReturnFlightsResults{" +
                "fromFlightCode='" + fromFlightCode + '\'' +
                ", fromAirLine='" + fromAirLine + '\'' +
                ", fromFlightScheduleId=" + fromFlightScheduleId +
                ", fromSource='" + fromSource + '\'' +
                ", fromDestination='" + fromDestination + '\'' +
                ", fromDepartureTime=" + fromDepartureTime +
                ", fromArrivalTime=" + fromArrivalTime +
                ", fromTotalHours=" + fromTotalHours +
                ", fromTicketPrice=" + fromTicketPrice +
                ", fromSeatsBooked=" + fromSeatsBooked +
                ", fromCapacity=" + fromCapacity +
                ", toFlightCode='" + toFlightCode + '\'' +
                ", toAirLine='" + toAirLine + '\'' +
                ", toFlightScheduleId=" + toFlightScheduleId +
                ", toSource='" + toSource + '\'' +
                ", toDestination='" + toDestination + '\'' +
                ", toDepartureTime=" + toDepartureTime +
                ", toArrivalTime=" + toArrivalTime +
                ", toTotalHours=" + toTotalHours +
                ", toTicketPrice=" + toTicketPrice +
                ", toSeatsBooked=" + toSeatsBooked +
                ", toCapacity=" + toCapacity +
                ", totalTicketPrice=" + totalTicketPrice +
                '}';
    }

    public String getFromFlightCode() {
        return fromFlightCode;
    }

    public void setFromFlightCode(String fromFlightCode) {
        this.fromFlightCode = fromFlightCode;
    }

    public String getFromAirLine() {
        return fromAirLine;
    }

    public void setFromAirLine(String fromAirLine) {
        this.fromAirLine = fromAirLine;
    }

    public Integer getFromFlightScheduleId() {
        return fromFlightScheduleId;
    }

    public void setFromFlightScheduleId(Integer fromFlightScheduleId) {
        this.fromFlightScheduleId = fromFlightScheduleId;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public void setFromDestination(String fromDestination) {
        this.fromDestination = fromDestination;
    }

    public Date getFromDepartureTime() {
        return fromDepartureTime;
    }

    public void setFromDepartureTime(Date fromDepartureTime) {
        this.fromDepartureTime = fromDepartureTime;
    }

    public Date getFromArrivalTime() {
        return fromArrivalTime;
    }

    public void setFromArrivalTime(Date fromArrivalTime) {
        this.fromArrivalTime = fromArrivalTime;
    }

    public Long getFromTotalHours() {
        return fromTotalHours;
    }

    public void setFromTotalHours(Long fromTotalHours) {
        this.fromTotalHours = fromTotalHours;
    }

    public BigDecimal getFromTicketPrice() {
        return fromTicketPrice;
    }

    public void setFromTicketPrice(BigDecimal fromTicketPrice) {
        this.fromTicketPrice = fromTicketPrice;
    }

    public Integer getFromSeatsBooked() {
        return fromSeatsBooked;
    }

    public void setFromSeatsBooked(Integer fromSeatsBooked) {
        this.fromSeatsBooked = fromSeatsBooked;
    }

    public Integer getFromCapacity() {
        return fromCapacity;
    }

    public void setFromCapacity(Integer fromCapacity) {
        this.fromCapacity = fromCapacity;
    }

    public String getToFlightCode() {
        return toFlightCode;
    }

    public void setToFlightCode(String toFlightCode) {
        this.toFlightCode = toFlightCode;
    }

    public String getToAirLine() {
        return toAirLine;
    }

    public void setToAirLine(String toAirLine) {
        this.toAirLine = toAirLine;
    }

    public Integer getToFlightScheduleId() {
        return toFlightScheduleId;
    }

    public void setToFlightScheduleId(Integer toFlightScheduleId) {
        this.toFlightScheduleId = toFlightScheduleId;
    }

    public String getToSource() {
        return toSource;
    }

    public void setToSource(String toSource) {
        this.toSource = toSource;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    public Date getToDepartureTime() {
        return toDepartureTime;
    }

    public void setToDepartureTime(Date toDepartureTime) {
        this.toDepartureTime = toDepartureTime;
    }

    public Date getToArrivalTime() {
        return toArrivalTime;
    }

    public void setToArrivalTime(Date toArrivalTime) {
        this.toArrivalTime = toArrivalTime;
    }

    public Long getToTotalHours() {
        return toTotalHours;
    }

    public void setToTotalHours(Long toTotalHours) {
        this.toTotalHours = toTotalHours;
    }

    public BigDecimal getToTicketPrice() {
        return toTicketPrice;
    }

    public void setToTicketPrice(BigDecimal toTicketPrice) {
        this.toTicketPrice = toTicketPrice;
    }

    public Integer getToSeatsBooked() {
        return toSeatsBooked;
    }

    public void setToSeatsBooked(Integer toSeatsBooked) {
        this.toSeatsBooked = toSeatsBooked;
    }

    public Integer getToCapacity() {
        return toCapacity;
    }

    public void setToCapacity(Integer toCapacity) {
        this.toCapacity = toCapacity;
    }

    public BigDecimal getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice(BigDecimal totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }
}
