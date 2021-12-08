package com.travel.travelAgency.commissions.DAO;

public enum CommissionCons {

    first(0.05),
    second(0.1),
    third(0.15);

    public final Double label;


    CommissionCons(double v) {
        this.label = v;
    }
}
