package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService; 

@RestController
@RequestMapping("/stud")
public class Controller {
	
	@Autowired
	StudentService studservice;
	
	@GetMapping("/demo")
	public String getstringfrom() {
		return "tushar from suit";
	}
	
	@GetMapping("/stud")
	public List<Student> getthelistofstud(){
		System.out.println("jakdsjf");
		return  studservice.getlistofstudent();
	}
	
	@PostMapping("/save")
	public Student savethestudent(@Valid  @RequestBody Student sud) {	
		return studservice.savethestudent(sud);
	}
	//save insert --@PostMapping
	//update ---@PutMapping
	@PutMapping("/update")
	public Student updatethestudentcity(@RequestBody Student stud){
		System.out.println(1123);
		Optional<Student> optinalstud =  studservice.findthestudentbyid(stud.getId());
		if(optinalstud.isPresent())
		{
			Student student = optinalstud.get();
			student.setCity(stud.getCity());
			studservice.updatethecityusingrollno(student.getId(),student.getCity().toString());
			return student;
		}
		return null;	
	}
	
	
	@GetMapping("/getbyname")
	public List<Student> getthelistofname(@RequestParam String name ){
		return  studservice.getthesudentbyname(name);
		
	}
	
	@PostMapping("/salstfstdnt")
	public List<Student> savthstdntlst(@RequestBody List<Student> stdlst){
		System.out.println(stdlst);
		return studservice.savthstdntthghlst(stdlst);
	}
	@PutMapping("/updatebyusingsave")
	public String datsngsav(@RequestParam Integer id,@RequestBody  Student stdlst) {
		Optional<Student> optinalstud =  studservice.findthestudentbyid(id);
		if(optinalstud.isPresent())
		{
			Student std =  optinalstud.get();
			std.setCity(stdlst.getCity());
			std.setEmail(stdlst.getEmail());
			studservice.savethestudent(std);
			return "succeesssfully saved";
		}
		return "errror occured " ;
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
