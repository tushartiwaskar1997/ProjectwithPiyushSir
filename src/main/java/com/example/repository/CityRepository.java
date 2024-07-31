package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.City;


@Repository
public interface CityRepository  extends JpaRepository<City, Integer> {

	public  Optional<City> findBycity(String cityname);
}
