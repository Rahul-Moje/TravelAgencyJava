package com.travel.travelAgency.search.models;

/**
 * @author rahulmoje
 */
public class FareInterval {

    private Integer intervalStart;

    private Integer intervalEnd;

    private Integer percentageIncrease;

    private FareInterval() {

    }

    private FareInterval(FareIntervalBuilder fareIntervalBuilder) {
        this.intervalStart = fareIntervalBuilder.intervalStart;
        this.intervalEnd = fareIntervalBuilder.intervalEnd;
        this.percentageIncrease = fareIntervalBuilder.percentageIncrease;
    }

    public boolean isDayWithinInterval(Integer days) {
        return this.intervalStart <= days && days <= this.intervalEnd;
    }

    @Override
    public String toString() {
        return "FareInterval{" +
                "intervalStart=" + intervalStart +
                ", intervalEnd=" + intervalEnd +
                ", percentageIncrease=" + percentageIncrease +
                '}';
    }

    public static class FareIntervalBuilder {

        private Integer intervalStart;

        private Integer intervalEnd;

        private Integer percentageIncrease;

        public FareIntervalBuilder() {

        }

        public FareIntervalBuilder withIntervalStart(Integer intervalStart) {
            this.intervalStart = intervalStart;
            return this;
        }

        public FareIntervalBuilder withIntervalEnd(Integer intervalEnd) {
            this.intervalEnd = intervalEnd;
            return this;
        }

        public FareIntervalBuilder withPercentageIncrease(Integer percentageIncrease) {
            this.percentageIncrease = percentageIncrease;
            return this;
        }

        public FareInterval build() {
            return new FareInterval(this);
        }
    }

    public Integer getIntervalStart() {
        return intervalStart;
    }

    public Integer getIntervalEnd() {
        return intervalEnd;
    }

    public Integer getPercentageIncrease() {
        return percentageIncrease;
    }

}
