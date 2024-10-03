package com.project.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.Enquiry;

public interface EnqRepo extends JpaRepository<Enquiry, Integer> {
	
	@Query(value = "select count(*) from enquiry where cons_id=:consId",nativeQuery = true)
	public long getEnquiry(int consId);
	
	
	@Query(value = "select count(*) from enquiry where cons_id=:consId and status=:status",nativeQuery = true)
	public long getEnquiryOpenStatus(int consId,String status);
	

}
