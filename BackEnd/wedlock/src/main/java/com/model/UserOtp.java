package com.model;

import java.time.LocalDateTime;


public class UserOtp {

	
	private int emailOtp;
	private LocalDateTime emailOtpExpiryTime;
	private int phoneOtp;
	private LocalDateTime phoneOtpExpiryTime;
	
	public UserOtp() {
		super();
	}
	
	public UserOtp(int emailOtp, LocalDateTime emailOtpExpiryTime, int phoneOtp, LocalDateTime phoneOtpExpiryTime) {
		super();
		this.emailOtp = emailOtp;
		this.emailOtpExpiryTime = emailOtpExpiryTime;
		this.phoneOtp = phoneOtp;
		this.phoneOtpExpiryTime = phoneOtpExpiryTime;
	}
	
	public int getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(int emailOtp) {
		this.emailOtp = emailOtp;
	}

	public LocalDateTime getEmailOtpExpiryTime() {
		return emailOtpExpiryTime;
	}

	public void setEmailOtpExpiryTime(LocalDateTime emailOtpExpiryTime) {
		this.emailOtpExpiryTime = emailOtpExpiryTime;
	}

	public int getPhoneOtp() {
		return phoneOtp;
	}

	public void setPhoneOtp(int phoneOtp) {
		this.phoneOtp = phoneOtp;
	}

	public LocalDateTime getPhoneOtpExpiryTime() {
		return phoneOtpExpiryTime;
	}

	public void setPhoneOtpExpiryTime(LocalDateTime phoneOtpExpiryTime) {
		this.phoneOtpExpiryTime = phoneOtpExpiryTime;
	}

	

	
}
