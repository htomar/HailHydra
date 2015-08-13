package org.hydra.mongodb.repositories;

import org.hydra.mongodb.model.Person;
import org.hydra.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface UserRepository extends MongoRepository<User, String>{

	public User findByEmailID(String emailID);

}