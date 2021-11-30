package com.travel.travelAgency.search.models;

import java.util.Date;

public class SearchFlightForm {

    private String source;

    private String destination;

    private Date fromDate;

    private Date toDate;

    private JourneyType journeyType;

    private Integer numOfPassengers;

    public SearchFlightForm(SearchFlightFormBuilder searchFlightFormBuilder) {
        this.source = searchFlightFormBuilder.source;
        this.destination = searchFlightFormBuilder.destination;
        this.fromDate = searchFlightFormBuilder.fromDate;
        this.toDate = searchFlightFormBuilder.toDate;
        this.numOfPassengers = searchFlightFormBuilder.numOfPassengers;
        this.journeyType = searchFlightFormBuilder.journeyType;
    }

    private SearchFlightForm() {

    }

    public static class SearchFlightFormBuilder {

        private String source;

        private String destination;

        private Date fromDate;

        private Date toDate;

        private JourneyType journeyType;

        private Integer numOfPassengers;

        public SearchFlightFormBuilder(String source, String destination) {
            this.source = source;
            this.destination = destination;
        }

        public SearchFlightFormBuilder withFromDate(Date fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public SearchFlightFormBuilder withToDate(Date toDate) {
            this.toDate = toDate;
            return this;
        }

        public SearchFlightFormBuilder withNumberOfPassengers(Integer numOfPassengers) {
            this.numOfPassengers = numOfPassengers;
            return this;
        }

        public SearchFlightFormBuilder withJourneyType(JourneyType journeyType) {
            this.journeyType = journeyType;
            return this;
        }

        public SearchFlightForm build() {
            return new SearchFlightForm(this);
        }
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }
}
