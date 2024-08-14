package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.UserDetails;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
	


    
    @Query(value = "select * from userdetails where fristname=?1 and password =?2 ",nativeQuery = true)
	public  Optional<UserDetails>  findByristnameandpassword(String fristname, String Password);
    
    @Query(value = "select * from userdetails where emailid=?1 and password =?2 ",nativeQuery = true)
	public Optional<UserDetails>  findByemailidandpassword(String emailid, String Password);
}