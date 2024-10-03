package com.project.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity

public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int EnId;
	
	private String StudentName;		
	private int StudentPhoneNumber;
	private String courseName;			
	private String classMode;			
	private String status;			
	
	
	@CreationTimestamp
	private LocalDate  createDate;	
	
	@UpdateTimestamp
	private LocalDate updateDate	;
	
	
	@ManyToOne
	@JoinColumn(name = "cons_id")
	private Cons cons;


	public int getEnId() {
		return EnId;
	}


	public void setEnId(int enId) {
		EnId = enId;
	}


	public String getStudentName() {
		return StudentName;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	public int getStudentPhoneNumber() {
		return StudentPhoneNumber;
	}


	public void setStudentPhoneNumber(int studentPhoneNumber) {
		StudentPhoneNumber = studentPhoneNumber;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getClassMode() {
		return classMode;
	}


	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


	public LocalDate getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}


	public Cons getCons() {
		return cons;
	}


	public void setCons(Cons cons) {
		this.cons = cons;
	}
	
}
