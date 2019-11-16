package com.nt.dao;

import java.util.List;

import com.nt.model.Person;

public interface PersonDAO {
	
	public void save(Person person);
	public Person getById(int id);
	public void update(int id,String email);
	public void delete(int id);
	public List<Person> getAllPersonDetails();
		
	
}

