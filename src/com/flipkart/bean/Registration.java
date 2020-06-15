// Bean class for registration contains userId, date and registration id .

package com.flipkart.bean;

import java.util.Date;

public class Registration {
	private int registrationId;
	private Date dateOfRegistration;
	private int userId;
	
	
	/**
	 * @return the registrationId
	 */
	public int getRegistrationId() {
		return registrationId;
	}
	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	/**
	 * @return the dateOfRegistration
	 */
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
