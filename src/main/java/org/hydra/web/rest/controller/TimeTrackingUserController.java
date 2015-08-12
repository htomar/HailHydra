package org.hydra.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.hydra.timetrack.db.beans.TimeTrackUsers;
import org.hydra.timetrack.db.repository.TimeTrackUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeTrackingUserController {
	@Autowired
	private TimeTrackUsersRepository timeTrackUsersRepository;

	@RequestMapping("/users")
	public List<TimeTrackUsers> getUsers() {
		List<TimeTrackUsers> usersList = new ArrayList<TimeTrackUsers>();
		Iterable<TimeTrackUsers> users = timeTrackUsersRepository.findAll();
		for (TimeTrackUsers user : users) {
			System.out.println(user.getFirstName());
			usersList.add(user);
		}
		return usersList;
	}
}
