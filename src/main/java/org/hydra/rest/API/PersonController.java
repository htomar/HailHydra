package org.hydra.rest.API;


import org.hydra.mongodb.model.Address;
import org.hydra.mongodb.model.Person;
import org.hydra.mongodb.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PersonController {
	private static final String template = "Hello, %s!";

    
    @Autowired
    private PersonRepository repository;

    public void setRepository(PersonRepository repository) {
		this.repository = repository;
	}

	@RequestMapping("/cperson")
    public Person cperson(@RequestParam(value="name", defaultValue="badal") String name) {
    	 
    	repository.deleteAll();

		// save a couple of customers
		repository.save(new Person(String.format(template, name), new Address("add1","add2")));
		
		

		// fetch all customers
		System.out.println("person found with findAll():");
		System.out.println("-------------------------------");
		Person person = repository.findByName(name);
			System.out.println(person);
		
		System.out.println();
		
        return person;
    }
}
