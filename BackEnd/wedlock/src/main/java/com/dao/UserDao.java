package com.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;
import com.model.UserOtp;

@Service
public class UserDao {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService emailService;
	
	UserOtp userOtp = new UserOtp();
	
	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
	
	public void registerUser(User user){
		
		String bCryptpw=bCrypt.encode(user.getPassword());
		user.setPassword(bCryptpw);
		userRepository.save(user);
	}
	
	public User login(String emailId,String password){
		User user = userRepository.findByemailId(emailId);
		
		if(bCrypt.matches(password, user.getPassword())){
			return user;
		}
		return null;
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	
	public User getUserById(int userId){
		return userRepository.findById(userId).orElse(null);
	}
	
	public User findByEmail(String emailId){
		return userRepository.findByEmailId(emailId);
	}
	
	public User findByName(String userName){
		return userRepository.findByuserName(userName);
	}
	
	public List<User> findByGender(String gender) {
        return userRepository.findByGender(gender);
    }
	
	public List<User> findByLocation(String location){
		return userRepository.findByLocation(location);
	}
	
	public List<User> findBymotherTongue(String motherTongue){
		return userRepository.findBymotherTongue(motherTongue);
	}
	
	public List<User> findByJob(String job){
		return userRepository.findByJob(job);
	}
	
	public List<User> findByEducation(String education){
		return userRepository.findByEducation(education);
	}
	
	public void updateUser(User user) {
//		String bCryptpw=bCrypt.encode(user.getPassword());
//		user.setPassword(bCryptpw);
		userRepository.save(user);
	}
	

	public void deleteUserById(int userId) {
		userRepository.deleteById(userId);
	}


	public List<User> findMatches(){
		return userRepository.findAll();
		
	}
	
	public List<User> findMale(){
		return userRepository.findMale();
	}
	
	public List<User> findFemale(){
		return userRepository.findFemale();
	}
	
	

	public boolean generateOTP(String emailId) {

		User user = userRepository.findByemailId(emailId);
		if(user != null){

			Random random = new Random();
			int otp = 100000 + random.nextInt(900000);			
			LocalDateTime time = LocalDateTime.now().plusMinutes(2);
			
			userOtp.setEmailOtp(otp);
			userOtp.setEmailOtpExpiryTime(time);
			
			SimpleMailMessage msg = new SimpleMailMessage();

			msg.setTo(emailId);
			msg.setSubject("One Time Password");
			msg.setText("your otp is : "+otp);
			
			javaMailSender.send(msg);
			return true;

		}
			return false;
		
	}
	
	public boolean validateEmailOtp(String emailId, int otp) {
		User user = userRepository.findByemailId(emailId);
		if(user != null) {
			if(userOtp.getEmailOtp() == otp && userOtp.getEmailOtpExpiryTime().isAfter(LocalDateTime.now())) {
				userOtp.setEmailOtp(0);
				userOtp.setEmailOtpExpiryTime(null);
				return true;
			}
		}
		return false;
	}

	

	public User userUpdate(String emailId,String password){
		User user = userRepository.findByEmailId(emailId);
		user.setPassword(bCrypt.encode(password));
		return userRepository.save(user);
	}

	
}
