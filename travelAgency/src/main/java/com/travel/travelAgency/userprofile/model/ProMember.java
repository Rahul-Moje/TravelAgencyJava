package com.travel.travelAgency.userprofile.model;

import java.util.Date;

/**
 * @author rahulmoje
 */
public class ProMember extends User {

    private PlanName planName;

    private Date dateOfPurchase;

    private ProMember() {

    }

    @Override
    public boolean isAdminUser() {
        return false;
    }

    @Override
    public String toString() {
        return "ProMember{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", proMember=" + proMember + '\'' +
                ", planName=" + planName + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }

    private ProMember(ProMemberBuilder proMemberBuilder) {
        super();
        this.userName = proMemberBuilder.userName;
        this.userEmail = proMemberBuilder.userEmail;
        this.proMember = proMemberBuilder.isProMember;
        this.planName = proMemberBuilder.planName;
        this.dateOfPurchase = proMemberBuilder.dateOfPurchase;
    }

    public static class ProMemberBuilder {

        private String userName;

        private String userEmail;

        private final boolean isProMember = true;

        private PlanName planName;

        private Date dateOfPurchase;

        public ProMemberBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public ProMemberBuilder withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public ProMemberBuilder withPlanName(PlanName planName) {
            this.planName = planName;
            return this;
        }

        public ProMemberBuilder withDateOfPurchase(Date dateOfPurchase) {
            this.dateOfPurchase = dateOfPurchase;
            return this;
        }

        public ProMember build() {
            return new ProMember(this);
        }
    }

    public PlanName getPlanName() {
        return planName;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }
}
