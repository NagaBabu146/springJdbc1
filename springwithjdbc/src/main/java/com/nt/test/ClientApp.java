package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.nt.model.Person;
import com.nt.service.PersonService;

public class ClientApp {

	public static void main(String[] args) {
		
	ApplicationContext context=new ClassPathXmlApplicationContext("/com/nt/cfgs/applicationContext.xml");
	
	  PersonService service = context.getBean(PersonService.class);
	//create model person obj
    Person person = new Person();
    
    person.setId(1);
    person.setName("NAGABABU");
    person.setEmail("barmanaga@gmail.com");
    person.setAdress("CHILLAKALLU");
    service.add(person);
    
    person.setId(2);
    person.setName("ABDUL");
    person.setEmail("abdul@gmail.com");
    person.setAdress("KANCHIKACHERLA");
    service.add(person);
    
    person.setId(3);
    person.setName("LAXMI");
    person.setEmail("laxmi@gmail.com");
    person.setAdress("CHENNAI");
    service.add(person);
    
    person.setId(4);
    person.setName("CHARAN");
    person.setEmail("charan@gmail.com");
    person.setAdress("HYDERABAD");
    service.add(person);
    
    person.setId(5);
    person.setName("KOPPU");
    person.setEmail("koppu@gmail.com");
    person.setAdress("VIZAG");
    service.add(person);
    System.out.println(service);
	}

}
