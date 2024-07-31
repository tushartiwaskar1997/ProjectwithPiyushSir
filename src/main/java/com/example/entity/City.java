package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer cityid ;
	
	private String city ;
	public City(Integer cityid, String city) {
		super();
		this.cityid = cityid;
		this.city = city;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
