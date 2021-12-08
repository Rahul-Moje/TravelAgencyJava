package com.travel.travelAgency.grievance.model;

/**
 * @author sowjanyamani
 */

public class Grievancerequest {
	
	private String email;
	private String complaint;
	
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}


public boolean isComplaintNull(String complaint) {
	if(complaint==null || complaint=="") {
		return false;
	}
	return true;
}

}
