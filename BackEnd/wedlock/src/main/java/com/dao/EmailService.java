package com.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailSender;
    
	public String emailVerify(String toEmailId, User user ){

		String otp = generateOtp();
		String subject = "Verification Code";
		String body = "Dear " + user.getUserName() + ",\n\n\n"
				+ "Your account setup is almost complete! "
				+ "just click the link below to activate your account: \n\n\n" 
				+ "http://localhost:8085/emailVerify/"+otp + "\n\n\n\n\n\n\n" + 
				"Best Regards,\n"
				+ "The Wedlock Team";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("wedlock125@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

		return otp;

	}

	
	
	public void registerEmailSender(String toEmailId, User user){
		String subject = "Registered Successfully";
		String body = "Hi " + user.getUserName() + "!\n\n"
				+ "Thank you for registering !!\n\n" +
				"Your Id is" + user.getUserId() + "\n\n\n\n\n\n\n" + 
				"Best Regards,\n"
				+ "The Wedlock Team";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("wedlock125@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		javaMailSender.send(mailMessage);

	}

	
	public String forgot(String toEmailId){

		String otp = generateOtp();
		String subject = "One Time Password";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("wedlock125@gmail.com");
		mailMessage.setTo(toEmailId);
		mailMessage.setSubject(subject);
		mailMessage.setText("Your OTP is:"+ otp);

		javaMailSender.send(mailMessage);

		return otp;

	}

	
	public String generateOtp() {
		UUID uuid = UUID.randomUUID();

		String uuidstring = uuid.toString();
		uuidstring = uuidstring.replace("-", "").toLowerCase();
		String otp = uuidstring.substring(0,6);

		return otp;
	}
}
