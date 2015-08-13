package org.hydra.timetrack.db.repository;

import org.hydra.timetrack.db.beans.TimeTrackUsers;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeTrackUsersRepository extends
		PagingAndSortingRepository<TimeTrackUsers, String> {
}
