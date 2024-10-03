package com.project.imps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Cons;
import com.project.repo.ConsRepo;
import com.project.service.ConsService;

@Service
public class ConsImps implements ConsService {

	@Autowired
	private ConsRepo consRepo;
	
	
	@Override
	public boolean consRegistretion(Cons cons) {
		
		Cons consEmailFind=consRepo.findByEmailid(cons.getEmailid());
		
		if(consEmailFind != null)
		{
			return false;
		}
		else
		{		
			Cons conObject= consRepo.save(cons);
			return cons.getCons_id()!=0;
		}
	}

	@Override
	public Cons getCons(String email, String password) {
		Cons cons= consRepo.findByEmailidAndPassword(email, password);
		return cons;
	}

}
