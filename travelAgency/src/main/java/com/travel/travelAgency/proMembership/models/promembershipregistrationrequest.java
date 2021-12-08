package com.travel.travelAgency.proMembership.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sowjanyamani
 */

public class promembershipregistrationrequest implements Serializable {

	private static final long serialVersionUID = 268932201854209904L;

	private String email;
	private String plan_name;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime now = LocalDateTime.now();
	String date = dtf.format(now);

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public boolean isPlanNameNull(String plan_name) {
		if(plan_name==null) {
			return false;
		}
		return true;
	}
}
