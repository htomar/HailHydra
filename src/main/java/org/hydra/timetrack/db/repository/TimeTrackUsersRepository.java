package org.hydra.timetrack.db.repository;

import java.util.List;

import org.hydra.timetrack.db.beans.TimeTrackUsers;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeTrackUsersRepository extends
		PagingAndSortingRepository<TimeTrackUsers, String> {

	List<TimeTrackUsers> findByFirstNameLike(String firstName);
}
