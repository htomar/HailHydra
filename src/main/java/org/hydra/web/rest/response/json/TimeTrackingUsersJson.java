package org.hydra.web.rest.response.json;

import java.util.ArrayList;
import java.util.List;

import org.hydra.timetrack.db.beans.TimeTrackUsers;

public class TimeTrackingUsersJson extends BaseJsonResponse {
	private List<TimeTrackUsers> timeTrackUsers;

	public TimeTrackingUsersJson(ResponseStatus responseStatus) {
		super(responseStatus);
		timeTrackUsers = new ArrayList<TimeTrackUsers>();
	}

	/**
	 * @return the timeTrackUsers
	 */
	public List<TimeTrackUsers> getTimeTrackUsers() {
		return timeTrackUsers;
	}

	/**
	 * @param timeTrackUsers
	 *            the timeTrackUsers to set
	 */
	public void setTimeTrackUsers(List<TimeTrackUsers> timeTrackUsers) {
		if (null != timeTrackUsers)
			this.timeTrackUsers = timeTrackUsers;
	}

}
