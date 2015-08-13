package org.hydra.mongodb.repositories;

import org.hydra.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>{
	
    public Person findByName(String name);
 

}
