package org.hydra.timetrack.db.repository;

import java.io.Serializable;

import org.hydra.timetrack.db.beans.InnovationTimeTracking;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InnovationTimeTrackingRepository extends
		PagingAndSortingRepository<InnovationTimeTracking, Serializable> {
	public InnovationTimeTracking findByEmailAndWeek(String email, long week);
}
