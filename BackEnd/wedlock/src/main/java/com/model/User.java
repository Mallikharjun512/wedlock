package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id@GeneratedValue
	private int userId;
	private String userName;
	private Date dateOfBirth;
	private String gender;
	private String motherTongue;
	private String location;
	private float height;
	private String education;
	private String job;
	private double salary;
	@Column(unique=true)
	private long phoneNumber;
	@Column(unique=true)
	private String emailId;
	private String password;
	private String request[];
	
	
	public User(){
		
	}
	
	
	
	public User(int userId, String userName, Date dateOfBirth, String gender, String motherTongue, String location,
			float height, String education, String job, double salary, long phoneNumber, String emailId,
			String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.motherTongue = motherTongue;
		this.location = location;
		this.height = height;
		this.education = education;
		this.job = job;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
	}



	public int getUserId() {
		return userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMotherTongue() {
		return motherTongue;
	}



	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public float getHeight() {
		return height;
	}



	public void setHeight(float height) {
		this.height = height;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String[] getRequest() {
		return request;
	}



	public void setRequest(String[] request) {
		this.request = request;
	}
	
	
	
	
	

}
