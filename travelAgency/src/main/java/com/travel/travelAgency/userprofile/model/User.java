package com.travel.travelAgency.userprofile.model;

/**
 * @author rahulmoje
 */
public class User {

    private static final String ADMIN_USERNAME = "admin";

    protected String userName;

    protected String userEmail;

    protected boolean proMember;

    public boolean isAdminUser() {
        return ADMIN_USERNAME.equals(this.userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", proMember=" + proMember +
                '}';
    }

    protected User() {

    }

    private User(UserBuilder userBuilder) {
        this.userName = userBuilder.userName;
        this.userEmail = userBuilder.userEmail;
        this.proMember = userBuilder.proMember;
    }

    public static class UserBuilder {

        private String userName;

        private String userEmail;

        private boolean proMember;

        public UserBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public UserBuilder withIsProMember(boolean proMember) {
            this.proMember = proMember;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public boolean isProMember() {
        return proMember;
    }
}
