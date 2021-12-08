package com.travel.travelAgency.authentication.models;

import java.io.Serializable;

/**
 * @author sowjanyamani
 */

public class ForgotPassGetEmailResp implements Serializable {

	private static final long serialVersionUID = -4852379021777260662L;

	private String security_question;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

}
