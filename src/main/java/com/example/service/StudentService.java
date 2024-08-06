package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Student;
import com.example.entity.Studentdtl;
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
	
	public Student  updatethecityusingrollno(Integer num , String city )
	{
		studentrepo.updatecity(num, city);
		
		return findthestudentbyid(num).get();
		
	}
	
	public List<Student> getthesudentbyname(String name){
		return studentrepo.findBystudname(name);
	}
	
	public List<Student>  savthstdntthghlst(List<Student> lst){
		return studentrepo.saveAll(lst);
	}
	public String  DeleteStudentbyId(Integer num) {
		studentrepo.deleteById(num);
		return "student deleted successfully";
	}
	public List<Student> savethestudentlistfromcsvfile(MultipartFile file){
		List<Student> listofstudent  =  new ArrayList<>();
		try(BufferedReader br  = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String  line ;
			
			while((line=br.readLine())!=null) {
				String[] fileds = line.split(","); 
				if(fileds.length==3) {
					Student stud = new Student(fileds[0],fileds[1],fileds[2]); 
					//if marsks is int in db then Integer.parseint();
					listofstudent.add(stud);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  studentrepo.saveAll(listofstudent);
	}
}
