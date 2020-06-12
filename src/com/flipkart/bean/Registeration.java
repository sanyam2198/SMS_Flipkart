package com.flipkart.bean;

import java.util.Date;

public class Registeration {
	private int registerationId;
	private Date dateOfRegisteration;
	private int userId;
	private int courseId;
	
	/**
	 * @return the registerationId
	 */
	public int getRegisterationId() {
		return registerationId;
	}
	/**
	 * @param registerationId the registerationId to set
	 */
	public void setRegisterationId(int registerationId) {
		this.registerationId = registerationId;
	}
	/**
	 * @return the dateOfRegisteration
	 */
	public Date getDateOfRegisteration() {
		return dateOfRegisteration;
	}
	/**
	 * @param dateOfRegisteration the dateOfRegisteration to set
	 */
	public void setDateOfRegisteration(Date dateOfRegisteration) {
		this.dateOfRegisteration = dateOfRegisteration;
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
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	

}
