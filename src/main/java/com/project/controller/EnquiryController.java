package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.project.entity.Cons;
import com.project.entity.Enquiry;
import com.project.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	// add enq
	@GetMapping("/enquiry")
	public String getEnquiry(Enquiry enquiry,Model model) {
		model.addAttribute("enq", new Enquiry());
		return "addEnq";
	}
	
	
	
	
	//save enq
	
	@PostMapping("/enquiry")
	public String postMethodName(Enquiry enq,Model model,HttpServletRequest req) {
		
		HttpSession session= req.getSession(false);
		 int ii=(Integer) session.getAttribute("cons_id");
		
		 boolean bb= enquiryService.addEnquiry(enq , ii);
		 
		 if(bb)
		 {
			 model.addAttribute("msg","Data inserted in Enquiry table");
		 }
		 else
		 {
			 model.addAttribute("emsg","Data failed to inserted in Enquiry table");
		 }
		 model.addAttribute("enq", new Enquiry());
		 return "addEnq";
		 
		 
	}
	
	
	//view enq
	
	@GetMapping("/enquiries")
	public String getEnquiry(HttpServletRequest req,Model model) {
		
		HttpSession session= req.getSession(false);
		int in=(Integer) session.getAttribute("cons_id");
		
		List<Enquiry> list= enquiryService.getEnquiries(new Enquiry(), in,"withoutFilter");
		
		model.addAttribute("enqs", list);
		
		model.addAttribute("enq", new Enquiry());
		
		
		return "viewEnqiry";
	}
	
	
	// filter enq
	
	@PostMapping("/filter-enqiry")
	public String postMethodName(HttpServletRequest req,Model model,Enquiry enq) {
		HttpSession session= req.getSession(false);
		int ii=(Integer) session.getAttribute("cons_id");
		
		List<Enquiry> list= enquiryService.getEnquiries(enq, ii,"withFilter");
		model.addAttribute("enqs",list );
		return "viewEnqiry";
	}
	
	
	// edit & update enq
	@PostMapping("/edit")
	public String editEnquiry(@RequestParam("enq_id") String enq_id,  Model modql)
	{
		Integer in=Integer.valueOf(enq_id);
		Enquiry enqq= enquiryService.getEnquiry(in);
		modql.addAttribute("enq", enqq);
		
		return "addEnq";
		
	}
	
	@GetMapping("/edit")
	public String editEnquiry1(@RequestParam("enq_id") String enq_id,  Model modql)
	{
		Integer in=Integer.valueOf(enq_id);
		Enquiry enqq= enquiryService.getEnquiry(in);
		modql.addAttribute("enq", enqq);
		
		return "editEnq";
	}
	
	
	
}
