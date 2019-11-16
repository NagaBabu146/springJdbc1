package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.PersonDAO;
import com.nt.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
	private PersonDAO dao;
	@Override
	public void add(Person person) {
		dao.save(person);
	}
	@Override
	public Person find(int id) {
		return dao.getById(id);
		
	}
	@Override
	public void remove(int id) {
		dao.delete(id);
		
	}
	@Override
	public void update(int id, String email) {
		dao.update(id, email);
	}
	@Override
	public List<Person> getAll() {
		return dao.getAllPersonDetails();
		
	}

}
