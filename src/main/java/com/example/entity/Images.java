package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/*
 * 
 create table Images(
 id int not null primary key,
 imagename varchar(255),
 imagetype varchar(255),
 imagedata longblob not null
 );
 * *?
 */

@Entity
@Table(name="images")
public class Images {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	private String  imagename ;
	
	private String  imagetype ;
	
	@Lob
	@Column(name = "")
	private byte[] imagedata ;

public Images(Integer id, String imagename, String imagetype, byte[] imagedata) {
	super();
	this.id = id;
	this.imagename = imagename;
	this.imagetype = imagetype;
	this.imagedata = imagedata;
}

public Images(String imagename, String imagetype, byte[] imagedata) {
	super();
	this.imagename = imagename;
	this.imagetype = imagetype;
	this.imagedata = imagedata;
}

public Images() {
	super();
	
}
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getImagename() {
	return imagename;
}

public void setImagename(String imagename) {
	this.imagename = imagename;
}

public String getImagetype() {
	return imagetype;
}

public void setImagetype(String imagetype) {
	this.imagetype = imagetype;
}

public byte[] getImagedata() {
	return imagedata;
}

public void setImagedata(byte[] imagedata) {
	this.imagedata = imagedata;
}
	
}
