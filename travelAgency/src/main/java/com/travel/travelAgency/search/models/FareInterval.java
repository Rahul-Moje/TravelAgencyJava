package com.travel.travelAgency.search.models;

public class FareInterval {

    private Integer intervalStart;

    private Integer intervalEnd;

    private Integer percentageIncrease;

    public Integer getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(Integer intervalStart) {
        this.intervalStart = intervalStart;
    }

    public Integer getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(Integer intervalEnd) {
        this.intervalEnd = intervalEnd;
    }

    public Integer getPercentageIncrease() {
        return percentageIncrease;
    }

    public void setPercentageIncrease(Integer percentageIncrease) {
        this.percentageIncrease = percentageIncrease;
    }
}
