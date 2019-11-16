package com.nt.model;

public class Person {

	private int id;
	private String name;
	private String email;
	private String adress;
	public Person() {
		System.out.println("Person:0-param constructor");
	}
	public Person(int id, String name, String email, String adress) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.adress = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", adress=" + adress + "]";
	}
	
}
