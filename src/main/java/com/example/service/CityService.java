package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.City;
import com.example.repository.CityRepository;

@Service
public class CityService {

	
	@Autowired
	CityRepository cityrepot ;
	
	public Optional<City> getcitybyname(String cityname){
		return cityrepot.findBycity(cityname);
	}
	
}
