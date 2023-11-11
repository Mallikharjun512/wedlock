package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	User findByemailId(String emailId);
	
	User findByuserName(String userName);
	
	List<User> findByGender(String gender);
	
	List<User> findByLocation(String location);
	
	List<User> findBymotherTongue(String motherTongue);
	
	List<User> findByJob(String job);
	
	List<User> findByEducation(String education);
	
	@Query("from User where gender='male'")
	List<User> findMale();
	
	@Query("from User where gender='female'")
	List<User> findFemale();

	User findByEmailId(String emailId);
	

}
