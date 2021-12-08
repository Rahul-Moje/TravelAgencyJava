package com.travel.travelAgency.userprofile.model;

/**
 * @author rahulmoje
 */
public enum PlanName {

    GOLD("Gold"),
    DIAMOND("Diamond"),
    PLATINUM("Platinum"),
    EMEARALD("Emaerald");

    private String description;

    PlanName(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PlanName mapPlanName(String plan) {
        for(PlanName planName : PlanName.values()) {
            if(planName.getDescription().equals(plan)) {
                return planName;
            }
        }
        throw new RuntimeException("Invalid plan");
    }
}
