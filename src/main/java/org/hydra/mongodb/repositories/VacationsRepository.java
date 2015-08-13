package org.hydra.mongodb.repositories;

import org.hydra.mongodb.model.Vacations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacationsRepository extends MongoRepository<Vacations, String>{
	

}