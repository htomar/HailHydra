package org.hydra.tasker.db.repository;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.hydra.tasker.db.beans.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends
		PagingAndSortingRepository<Task, Serializable> {

	public List<Task> findByUserId(String userId);

	public Task findById(ObjectId id);
}
