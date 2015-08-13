package org.hydra.mongodb.repositories;

import org.hydra.mongodb.model.Releases;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReleasesRepository extends MongoRepository<Releases, String>{
	

}