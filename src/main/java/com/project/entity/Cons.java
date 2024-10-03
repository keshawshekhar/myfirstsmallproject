package com.project.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Cons {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cons_id;		
	private String name;		
	private String emailid;	
	private String password;	
	private String phoneno;
	
	
	@CreationTimestamp
	private LocalDate createDate;
	
	@UpdateTimestamp	
	private LocalDate updateDate;	
	
	
	@OneToMany(mappedBy = "cons",cascade = CascadeType.ALL)
	private List<Enquiry> enq;


	public int getCons_id() {
		return cons_id;
	}


	public void setCons_id(int cons_id) {
		this.cons_id = cons_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


		public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
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


	public List<Enquiry> getEnq() {
		return enq;
	}


	public void setEnq(List<Enquiry> enq) {
		this.enq = enq;
	}
	
	
	


}
