package com.travel.travelAgency.bookings.model;

public enum MealType {

    VEGETARIAN("Vegetarian"),
    NONVEGETARIAN("Non vegetarian");

    private String description;

    MealType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static MealType mapToMealType(String description) {
        for(MealType mealType : MealType.values()) {
            if(mealType.description.equals(description))
            {
                return mealType;
            }
        }
        throw new RuntimeException("Invalid Value!");
    }
}
