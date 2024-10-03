package com.project.service;

import com.project.entity.Cons;

public interface ConsService {

	public boolean consRegistretion(Cons cons);
	
	public Cons getCons(String email,String password);
}
