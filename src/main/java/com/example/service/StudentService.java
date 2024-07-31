package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentrepo;
	
	public List<Student> getlistofstudent(){
		System.out.println("hi");
		return studentrepo.findAll();
	}
	
	public Optional<Student> findthestudentbyid(Integer id)
	{
		return  studentrepo.findById(id);
	}
	
	public Student savethestudent(Student stud ) {	
		studentrepo.save(stud);
		return stud ;
	}
	
	public String  updatethecityusingrollno(Integer num , String city )
	{
		studentrepo.updatecity(num, city);
		return "Succeffula !!" ;
		
	}
	
	public List<Student> getthesudentbyname(String name){
		return studentrepo.findBystudname(name);
	}
	
	public List<Student>  savthstdntthghlst(List<Student> lst){
		return studentrepo.saveAll(lst);
	}
}
