package com.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserDetails;
import com.example.repository.UserDetailsRepository;

@Service
public class UserDetailsService {

	
	
	@Autowired
	private UserDetailsRepository userrepo ;
	
	public UserDetails savetheuser(UserDetails user) {
		user.setCreatedon(LocalDateTime.now());
		user.setCreatedby("Admin");
		user.setIsActive(1);
		return userrepo.save(user);
	}
	
	public Optional<UserDetails>  gettheuserdetailsbyUsernameandpass(String username  ,String pass){
		return  userrepo.findByristnameandpassword(username, pass);
	}

	public Optional<UserDetails>  gettheuserdetailsbyEmailandPass(String username  ,String pass){
		return  userrepo.findByemailidandpassword(username, pass);
	}
}
