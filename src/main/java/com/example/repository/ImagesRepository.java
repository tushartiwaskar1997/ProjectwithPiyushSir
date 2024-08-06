package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Images;

public interface ImagesRepository  extends JpaRepository<Images, Integer> {
	

}
