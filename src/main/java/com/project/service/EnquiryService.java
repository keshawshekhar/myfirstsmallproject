package com.project.service;

import java.util.List;

import com.project.dto.DashboardDTO;
import com.project.entity.Enquiry;

public interface EnquiryService {
	
	public DashboardDTO getDashboardData(int cons_id);
	
	public boolean addEnquiry(Enquiry enq , int cons_id);
	
	public List<Enquiry> getEnquiries( Enquiry enq,int cons_id,String marker);
	
	public Enquiry getEnquiry(int enq_id);

}
