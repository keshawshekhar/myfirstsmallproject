package com.project.imps;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.project.dto.DashboardDTO;
import com.project.entity.Cons;
import com.project.entity.Enquiry;
import com.project.repo.ConsRepo;
import com.project.repo.EnqRepo;
import com.project.service.EnquiryService;

@Service
public class EnquiryImps implements EnquiryService{

	@Autowired
	private EnqRepo enqRepo;
	
	@Autowired
	private ConsRepo consRepo;
	
	@Override
	public DashboardDTO getDashboardData(int cons_id) {
		long totalEnq=enqRepo.getEnquiry(cons_id);
		long openEnq=enqRepo.getEnquiryOpenStatus(cons_id, "New");
		long enrolledEnq=enqRepo.getEnquiryOpenStatus(cons_id, "Old");
		long lostEnq=enqRepo.getEnquiryOpenStatus(cons_id, "Lost");
		
		
		return new DashboardDTO(totalEnq, openEnq, enrolledEnq, lostEnq);
	} 

	@Override
	public boolean addEnquiry(Enquiry enq,int cons_id ) {
		
		Cons cons=consRepo.findById(cons_id).orElseThrow();
		
		enq.setCons(cons);
		Enquiry en= enqRepo.save(enq);
		return en.getEnId()!=0;
	}

	@Override
	public List<Enquiry> getEnquiries(Enquiry enq, int cons_id,String marker) {
		Cons cons = consRepo.findById(cons_id).orElseThrow();
		enq.setCons(cons);
		ExampleMatcher matcher=null;
		Example<Enquiry> exam=null;
		 if(marker.equals("withoutFilter"))
		 {
		
		matcher = ExampleMatcher.matching().withIgnoreNullValues()
			    .withIgnorePaths("EnId","StudentName","StudentPhoneNumber","courseName","classMode","status");
		exam=Example.of(enq,matcher);
		 }
		 else
		 {
			 Enquiry enqr=new Enquiry();
			 if(!enq.getCourseName().equals(""))
			 {
				 enqr.setCourseName(enq.getCourseName());
			 }
			 if(!enq.getClassMode().equals(""))
			 {
				 enqr.setClassMode(enq.getClassMode());
			 }
			 if(!enq.getStatus().equals(""))
			 {
				 enqr.setStatus(enq.getStatus());
			 }
			 
			 
			 
			 matcher = ExampleMatcher.matching().withIgnoreNullValues()
					    .withIgnorePaths("EnId","StudentName","StudentPhoneNumber");
					    
					    
			 exam=Example.of(enqr,matcher);
		 }
//		System.out.println(enqRepo.findAll(exam));
		
		return enqRepo.findAll(exam);
	}

	@Override
	public Enquiry getEnquiry(int enq_id) {
		
		return enqRepo.findById(enq_id).orElseThrow();
	}

}
