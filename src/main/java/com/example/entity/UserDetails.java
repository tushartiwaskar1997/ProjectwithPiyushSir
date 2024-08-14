package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userdetails")
public class UserDetails {

	
	//userid ,fristname , lastname, dob, emailid , mobileno ,isActive
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid ;
	
	@NotEmpty(message = "the first name should not be blank it is empty ")
	@Size(min = 3 , max = 10 , message = "plese enter the name between  3 - 10 character  !!!")
	private String fristname ;
	
	@NotEmpty(message ="lastname is blank ")
	private String lastname ;
	
	@NotEmpty(message = "password is blank")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).*$" ,
	message = "Password must contain at least one uppercase letter, one special character, and one digit")
	@Size(min = 6 , max = 10 ,message = "please enter the password between 6 -10 character  ")
	private String password ;
	@NotNull(message = "date of birth is not present  ")
	private LocalDate dob ;
	
	@Email(message = "Email should be valid ")
	@NotEmpty(message ="Email is empty")
	@Column(name="emailid")
	private String  emailid;
	
	@NotEmpty(message = "mobile no is empty ")
	private String  mobileno;
	
	@NotEmpty(message = "gender should be present  ")
	private String gender ;
	@Column(name="isActive")
	private Integer isActive ;
	private String createdby ;
	private LocalDateTime createdon;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(Integer userid,
			@NotEmpty(message = "the first name should not be blank it is empty ") @Size(min = 3, max = 10, message = "plese enter the name between  3 - 10 character  !!!") String fristname,
			@NotEmpty(message = "lastname is blank ") String lastname,
			@NotEmpty(message = "password is blank") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).*$", message = "Password must contain at least one uppercase letter, one special character, and one digit") @Size(min = 6, max = 10, message = "please enter the password between 6 -10 character  ") String password,
			@NotNull(message = "date of birth is not present  ") LocalDate dob,
			@Email(message = "Email should be valid ") @NotEmpty(message = "Email is empty") String emailid,
			@NotEmpty(message = "mobile no is empty ") String mobileno,
			@NotEmpty(message = "gender should be present  ") String gender, Integer isActive, String createdby,
			LocalDateTime createdon) {
		super();
		this.userid = userid;
		this.fristname = fristname;
		this.lastname = lastname;
		this.password = password;
		this.dob = dob;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.gender = gender;
		this.isActive = isActive;
		this.createdby = createdby;
		this.createdon = createdon;
	}
	public UserDetails(
			@NotEmpty(message = "the first name should not be blank it is empty ") @Size(min = 3, max = 10, message = "plese enter the name between  3 - 10 character  !!!") String fristname,
			@NotEmpty(message = "lastname is blank ") String lastname,
			@NotEmpty(message = "password is blank") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).*$", message = "Password must contain at least one uppercase letter, one special character, and one digit") @Size(min = 6, max = 10, message = "please enter the password between 6 -10 character  ") String password,
			@NotNull(message = "date of birth is not present  ") LocalDate dob,
			@Email(message = "Email should be valid ") @NotEmpty(message = "Email is empty") String emailid,
			@NotEmpty(message = "mobile no is empty ") String mobileno,
			@NotEmpty(message = "gender should be present  ") String gender, Integer isActive) {
		super();
		this.fristname = fristname;
		this.lastname = lastname;
		this.password = password;
		this.dob = dob;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.gender = gender;
		this.isActive = isActive;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getFristname() {
		return fristname;
	}
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	@Override
	public String toString() {
		return "UserDetails [userid=" + userid + ", fristname=" + fristname + ", lastname=" + lastname + ", password="
				+ password + ", dob=" + dob + ", emailid=" + emailid + ", mobileno=" + mobileno + ", gender=" + gender
				+ ", isActive=" + isActive + ", createdby=" + createdby + ", createdon=" + createdon + "]";
	}
	
	
	
	
	
}
