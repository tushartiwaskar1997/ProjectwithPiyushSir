package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.City;
import com.example.entity.Studentdtl;
import com.example.repository.StudentdetailsRepository;

@Service
public class StudentdetailsService {

	@Autowired
	StudentdetailsRepository studentdetailsrepo ;
	
	
	public List<Studentdtl> getalldedtails(){
		return  studentdetailsrepo.findAll();
	}
	
	public List<Studentdtl> getlistofstudentbycityid(City  city ){
		
		return  studentdetailsrepo.findBycity(city);
	}
}
