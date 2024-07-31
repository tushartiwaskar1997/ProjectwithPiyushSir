package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="studentdtl")
public class Studentdtl {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "please enter the nameeee ")
	private String stdnam;
	private String lastnam;
	
	@ManyToOne
	@JoinColumn(name="cityid")
	private City city;
	private Integer marks;
	
	
	
	public Studentdtl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Studentdtl(Integer id, @NotEmpty(message = "please enter the nameeee ") String stdnam, String lastnam,
			City city, Integer marks) {
		super();
		this.id = id;
		this.stdnam = stdnam;
		this.lastnam = lastnam;
		this.city = city;
		this.marks = marks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStdnam() {
		return stdnam;
	}
	public void setStdnam(String stdnam) {
		this.stdnam = stdnam;
	}
	public String getLastnam() {
		return lastnam;
	}
	public void setLastnam(String lastnam) {
		this.lastnam = lastnam;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
	
	
	
	
}
