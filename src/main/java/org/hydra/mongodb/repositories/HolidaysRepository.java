package org.hydra.mongodb.repositories;

import org.hydra.mongodb.model.Holidays;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HolidaysRepository extends MongoRepository<Holidays, String>{
	

}
