package com.jdc.assignment.model;

import java.util.List;

import com.jdc.assignment.domain.Registeration;

public interface RegisterationModel {
	
	void create(Registeration registeration);
	
	List<Registeration> findByClass(int id);
	List<Registeration> getAll();
	
	
}
