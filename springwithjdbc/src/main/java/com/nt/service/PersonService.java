package com.nt.service;

import java.util.List;

import com.nt.model.Person;

public interface PersonService {
	
	public void add(Person person);
	public Person find(int id);
	public void remove(int id);
	public void update(int id,String email);
	public List<Person> getAll();
}
