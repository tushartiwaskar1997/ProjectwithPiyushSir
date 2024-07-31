package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseEntityStudentdetails;
import com.example.dto.StudentDto;
import com.example.entity.City;
import com.example.entity.Studentdtl;
import com.example.service.CityService;
import com.example.service.StudentdetailsService;

@RestController
@RequestMapping("/det")
public class StudentdetailsController {
	
	@Autowired 
	StudentdetailsService studserive;
	
	@Autowired
	CityService Cityservice; 
	
	@GetMapping("/get")
	public List<Studentdtl> getallthelist(){
		return studserive.getalldedtails();
	}
	
	/// this code is added  to get the proper Response with http status code 
	@GetMapping("/getResp")
	public ResponseEntity<ResponseEntityStudentdetails > getstudentlistinResponseEntity(){
		ResponseEntityStudentdetails response  =  new ResponseEntityStudentdetails();
		List<Studentdtl> listofstudetn  = studserive.getalldedtails();
		
		if(!listofstudetn.isEmpty())
		{
			response.setMessage("List is empty some this is wrong  ");
			return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
		}else
		{
			response.setMessage("record featched successfully  !!!");
			response.setStudentlist(listofstudetn);
		}
		return  new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getcity")
	public Optional<City> getcitydetailsbyname(@RequestParam String nameofcity){
		return Cityservice.getcitybyname(nameofcity);
	}
	
	@GetMapping("/getlistofstudentsbycityname")
	public List<Studentdtl> findthestudentListByCity(@RequestParam String  nameofcity){
			if(Cityservice.getcitybyname(nameofcity).isPresent())
			{
				City  city =  Cityservice.getcitybyname(nameofcity).get();
				List<Studentdtl> listofstudent  =  studserive.getlistofstudentbycityid(city);	
				return listofstudent;
			}	
		return  null; 
	}
	
	@GetMapping("/getthelistindtoformat")
	public List<StudentDto> getthelistofstudebyciynameindtoformat(@RequestParam String cityname){
		if(Cityservice.getcitybyname(cityname).isPresent())
		{
			City  city =  Cityservice.getcitybyname(cityname).get();
			List<Studentdtl> listofstudent  =  studserive.getlistofstudentbycityid(city);	
			List<StudentDto> resut  = new ArrayList<>();
			for(Studentdtl std : listofstudent)
			{
				StudentDto stud =  new StudentDto(std.getStdnam(), std.getLastnam(), std.getCity().getCity());
				resut.add(stud);  		
			}
			return resut;
		}	
	return  null;
	}

}
