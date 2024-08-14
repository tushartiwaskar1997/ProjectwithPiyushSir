package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserDetails;
import com.example.service.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {

	@Autowired
	private UserDetailsService userservice ;
	
	@GetMapping("/login")
	public ResponseEntity<?>  login(@RequestParam("username")String username , @RequestParam("password") String pass ) {
		
		Optional<UserDetails> responsefromusername  = userservice.gettheuserdetailsbyUsernameandpass(username, pass);
		 //user name can be email
		Optional<UserDetails> responsefromemail = userservice.gettheuserdetailsbyEmailandPass(username, pass);   
		
		if(responsefromusername.isPresent()) {
			return new ResponseEntity<>(responsefromusername.get() , HttpStatus.OK);
		}else if( responsefromemail.isPresent())
		{
			return new ResponseEntity<>(responsefromemail.get() , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("user not found please check the cridentidls " , HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public UserDetails savetheusertodb(@Valid  @RequestBody UserDetails user){
		return userservice.savetheuser(user);
	}	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String>  methodforvalisation(MethodArgumentNotValidException ErrorGenerated){
		Map<String,String> errors = new HashMap<>();
		List<ObjectError> allerrors =  ErrorGenerated.getBindingResult().getAllErrors();
		for(ObjectError error :  allerrors )
		{
			String fieldname = ((org.springframework.validation.FieldError)error).getField();
			String errormessage = error.getDefaultMessage();
			errors.put(fieldname, errormessage);
		}
		return errors;
	}
}

/*
{
	  "userid": 123,
	  "firstname": "John",
	  "lastname": "Doe",
	  "dob": "1990-01-01",
	  "emailid": "johndoe@example.com",
	  "mobileno": "1234567890",
	  "status": 1,
	  "createdby": "admin",
	  "createdon": "2024-08-11"
	}
*/
