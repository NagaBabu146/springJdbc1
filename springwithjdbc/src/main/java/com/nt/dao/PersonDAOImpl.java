package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.model.Person;
@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final String INSERT_QUERY="INSERT INTO PERSON(ID,NAME,EMAIL,ADDRESS) VALUES(?,?,?,?)";
	private static final String GET_QUERY="SELECT ID,NAME,EMAIL,ADRESS FROM PERSON WHERE ID=?";
	private static final String UPDATE_QUERY="UPDATE PERSON SET EMAIL=?,WHERE ID=?"; 
	private static final String DELETE_QUERY="DELETE FROM PERSON WHERE ID=?";
	private static final String GET_ALL_QUERY="SELECT ID,NAME,EMAIL,ADRESS FROM PERSON";
	
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
	@Override
	public void save(Person person) {
		jdbcTemplate.update(INSERT_QUERY, person.getId(),
				                          person.getName(),
				                          person.getEmail(),
			                           	  person.getAdress());
       System.out.println("saved");
	}

	@Override
	public Person getById(int id) {
		/*
		 * Person person=(Person)jdbcTemplate.queryForObject(GET_QUERY, new Object[])
		 * {id},new BeanPropertyRowMapper(Person.class)); return person;
		 */
		Person person = jdbcTemplate.queryForObject(GET_QUERY, new PersonRowMapper(),id);
		return person;
	}
	private class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println(" from mapRow method");
			//keep the record of ResultSet into Person class obj
			Person person =new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			return person;
		}//mapRow method	
	}//innerclass
	@Override
	public void update(int id, String newEmail) {
		
		jdbcTemplate.update(UPDATE_QUERY, newEmail, id);
	}

	@Override
	public void delete(int id) {
	jdbcTemplate.update(DELETE_QUERY,id);
	}

	@Override
	public List<Person> getAllPersonDetails() {
		return jdbcTemplate.query(GET_ALL_QUERY, new ResultSetExtractor<List<Person>>(){
			
			@Override
			public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Person> list=new ArrayList<>();
				while(rs.next()) {
					Person p=new Person();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setEmail(rs.getString(3));
					p.setAdress(rs.getString(4));
					list.add(p);
				}//while
				return list;
			}//extractData() method
		
		});//anynomous inner class
		
	}//method
	
}
