package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Cons;
import java.util.List;


public interface ConsRepo extends JpaRepository<Cons, Integer> {
	
	
	public Cons findByEmailidAndPassword(String email_id, String password);
	
	public Cons  findByEmailid(String email_id);
	
	

}
