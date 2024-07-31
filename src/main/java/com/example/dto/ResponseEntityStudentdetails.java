package com.example.dto;

import java.util.List;

import com.example.entity.Studentdtl;

public class ResponseEntityStudentdetails {
		
	
		private  List<Studentdtl> studentlist ;
		private String message ;
		public List<Studentdtl> getStudentlist() {
			return studentlist;
		}
		public void setStudentlist(List<Studentdtl> studentlist) {
			this.studentlist = studentlist;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public ResponseEntityStudentdetails(List<Studentdtl> studentlist, String message) {
			super();
			this.studentlist = studentlist;
			this.message = message;
		}
		public ResponseEntityStudentdetails() {
			super();
			// TODO Auto-generated constructor stub
		} 
	
}
