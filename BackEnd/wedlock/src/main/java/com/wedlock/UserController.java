package com.wedlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmailService;
import com.dao.UserDao;
import com.model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userdao;
	
	@Autowired
	EmailService emailSerivce;
	
	
	@GetMapping("getUsers")
	public List<User> getUsers() {
		return userdao.getUsers();
	}

	
	@GetMapping("getUserById/{userId}")
	public User getUserById(@PathVariable("userId") int userId){
		return userdao.getUserById(userId);
	}
	
	@GetMapping("findByEmail/{emailId}")
	public User findByEmail(@PathVariable("emailId") String emailId){
		return userdao.findByEmail(emailId);
	}
	
	@GetMapping("login/{emailId},{password}")
	public User login(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {

	  return userdao.login(emailId, password);
	}
	
	@PostMapping("registerUser")
	public String registerUser(@RequestBody User user){
		userdao.registerUser(user);
		return "Registred Sucessfully";
	}

	@PostMapping("registerUserotp")
	public String registerUserotp(@RequestBody User user,HttpSession session) {
		String otp = emailSerivce.emailVerify(user.getEmailId(), user);
		
		session.setAttribute("otp", otp);
		session.setAttribute("Userdata", user);
		session.setAttribute("emailId", user.getEmailId());
		return "Registered Successfully!!!";
	}

	@PutMapping("emailVerify/{otp}")
	public String emailVerification(HttpSession session,@PathVariable("otp") String otp){
		
		if(session.getAttribute("otp").equals(otp)){
			userdao.registerUser((User)session.getAttribute("Userdata"));
			emailSerivce.registerEmailSender(session.getAttribute("emailId").toString(),(User)session.getAttribute("Userdata"));
		    return "Registered Sucessfully";
		}
		else{
			return "OTP Invalid";
		}
	}
	
	@GetMapping("findByName/{userName}")
	public User findByName(@PathVariable("userName") String userName){
		return userdao.findByName(userName);
	}
	
	@GetMapping("findByGender/{gender}")
    public List<User> findByGender(@PathVariable("gender") String gender) {
        return userdao.findByGender(gender);
    }
	
	@GetMapping("findByLocation/{location}")
	public List<User> findByLocation(@PathVariable("location") String location){
		return userdao.findByLocation(location);
	}
	
	@GetMapping("findBymotherTongue/{motherTongue}")
	public List<User> findBymotherTongue(@PathVariable("motherTongue") String motherTongue){
		return userdao.findBymotherTongue(motherTongue);
	}
	
	@GetMapping("findByJob/{job}")
	public List<User> findByJob(@PathVariable("job") String job){
		return userdao.findByJob(job);
	}
	
	@GetMapping("findByEducation/{education}")
	public List<User> findByEducation(@PathVariable("education") String education){
		return userdao.findByEducation(education);
	}
	
	@GetMapping("findMatches")
	public List<User> findMatches(){
		return userdao.findMatches();
	}
	
	@GetMapping("findMale")
	public List<User> findMale(){
		return userdao.findMale();
	}
	
	@GetMapping("findFemale")
	public List<User> findFemale(){
		return userdao.findFemale();
	}
	
	
	@PutMapping("updateUser")
	public String updateUser(@RequestBody User user) {
		userdao.updateUser(user);
		return "user Updated Successfully!!!";
	}
	
	@PutMapping("passwordReset/{emailId},{password}")
	public User userUpdate(@PathVariable("emailId") String emailId,@PathVariable() String password){
		return userdao.userUpdate(emailId, password);
	}
	
	
	@PostMapping("getEmailOtp")
	public ResponseEntity<Map<String, String>> EmailOtp(@RequestBody String emailId) {
		Map <String, String> response = new HashMap<>();
		if(userdao.generateOTP(emailId)) {
			response.put("message", "OTP is Sent");
			return ResponseEntity.ok(response);
		}
		else {
			return null;
		}
		
	}
	
	@PutMapping("validateEmailOtp/{emailId}/{otp}")
	public ResponseEntity<Map<String, String>> validateEmailOtp(@PathVariable("emailId") String emailId, @PathVariable("otp") int otp) {
		Map <String, String> response = new HashMap<>();
		if(userdao.validateEmailOtp(emailId, otp)) {
			response.put("message", "OTP Verified");
			return ResponseEntity.ok(response);
		}
		else {
			return null;
		}
	}


}
