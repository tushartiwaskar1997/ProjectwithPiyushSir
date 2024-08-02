package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.entity.Student;
import com.example.service.StudentService;

public class TestController {
	
	@InjectMocks
	private Controller controller ;
	
	@Mock
	private  StudentService studentservice ;
	
	@BeforeEach
	public  void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testclassworkingornot() {
		
		String expected  ="check the class";
		assertEquals(expected, "check the class");
	}
	
	
	public List<Student>  getstudentlist(){
		List<Student> list =  new ArrayList<>();
		Student stude1 = new Student(1, "Tushar", "ngp","null");
		Student stude2 = new Student(2, "kartik", "ngp","null");
		Student stude3 = new Student(3, "prajwal", "ngp","null");
		list.add(stude1);
		list.add(stude2);
		list.add(stude1);
		return  list ;
	}
	
	 @Test
	 public void testGetAll() { 
		 List<Student> expected =   getstudentlist();
		 when(studentservice.getlistofstudent()).thenReturn(expected);
		 List<Student> controlleroutput = controller.getthelistofstud();
		 assertEquals(expected, controlleroutput);
	 }
	 
	 @Test
	 public void testsavethestudent() {
		 Student stud1 =  new Student();
		 when(studentservice.savethestudent(any(Student.class))).thenReturn(stud1);
		 Student response =  controller.savethestudent(stud1);
		 assertEquals(stud1, response); 
	 }
	 
	 @Test
	 public void  testupdatethestudentcity() {
		 Student stud1 =  new Student(1, "tushar", "ngp", "null");
		 Student updatedstudentcity =  new Student(1, "", "chi", "null");
		 Student updatedstudent_after =  new Student(1, "tushar", "chi", "null");
		 when(studentservice.findthestudentbyid(anyInt())).thenReturn( Optional.of(stud1));
		 when(studentservice.updatethecityusingrollno(1, "chi")).thenReturn(updatedstudent_after);
		 Student  response  =  controller.updatethestudentcity(updatedstudentcity);

		 assertEquals(updatedstudent_after.toString(), response.toString());
	 }
	 
	 @Test
	 public void testDeleteTheStudentById() {
		 String expected = "student deleted successfully";
		 when(studentservice.DeleteStudentbyId(anyInt())).thenReturn("student deleted successfully");
		 String actualoutput = controller.DeleteTheStudentById(1);
		 assertEquals(expected, actualoutput);
		 
	 }

}
