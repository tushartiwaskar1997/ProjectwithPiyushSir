package com.example.dto;

public class StudentDto {

	private String stdnam;
	private String lastnam;
	private String cityname;
	
	
	
	public StudentDto(String stdnam, String lastnam, String cityname) {
		super();
		this.stdnam = stdnam;
		this.lastnam = lastnam;
		this.cityname = cityname;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
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
	public StudentDto(String stdnam, String lastnam) {
		super();
		this.stdnam = stdnam;
		this.lastnam = lastnam;
	}
	public StudentDto() {
		super();
	}
	
}
