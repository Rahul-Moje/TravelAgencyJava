package com.travel.travelAgency.model;

import java.io.Serializable;

public class SecurityAnswerRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	 
	private String security_answer;
	
	private String new_password;
	private String update_password;

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getUpdate_password() {
		return update_password;
	}

	public void setUpdate_password(String update_password) {
		this.update_password = update_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
