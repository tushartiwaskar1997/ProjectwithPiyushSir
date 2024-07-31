package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

//import jakarta.transaction.Transactional;

import java.util.List;

import javax.transaction.Transactional;


@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{

	
	
	public  List<Student>  findBystudname(String  name);
	
	
	
	@Transactional
	@Modifying
	@Query(value="update student set city =?2 where id =?1 ",nativeQuery = true)
	void updatecity(Integer id , String city );
	
}
