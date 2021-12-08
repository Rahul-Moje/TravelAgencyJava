package com.travel.travelAgency.search.models;

/**
 * @author rahulmoje
 */
public enum JourneyType {

    ONE_WAY("OneWay"),
    RETURN("Return");

    private String description;

    JourneyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static JourneyType mapToJourneyType(String description) {
        for(JourneyType journeyType : JourneyType.values()) {
            if(journeyType.description.equals(description))
            {
                return journeyType;
            }
        }
        throw new RuntimeException("Invalid Value!");
    }
}
