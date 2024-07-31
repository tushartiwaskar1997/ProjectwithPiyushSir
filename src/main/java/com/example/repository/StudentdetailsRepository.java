package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.City;
import com.example.entity.Studentdtl;

@Repository
public interface StudentdetailsRepository extends JpaRepository<Studentdtl, Integer> {

	public List<Studentdtl> findBycity(City city);
	
}
