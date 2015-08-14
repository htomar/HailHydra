package org.hydra.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.hydra.timetrack.db.beans.TimeTrackUsers;
import org.hydra.timetrack.db.repository.TimeTrackUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeTrackingUserController {
	@Autowired
	private TimeTrackUsersRepository timeTrackUsersRepository;

	@RequestMapping("/users")
	public List<TimeTrackUsers> getUsers() {
		List<TimeTrackUsers> usersList = new ArrayList<TimeTrackUsers>();
		TimeTrackUsers newUser = new TimeTrackUsers();
		newUser.setUserId("htomar");
		newUser.setFirstName("Himanshu");
		newUser.setLastName("Tomar");
		newUser.setTeam("Hydra");
		timeTrackUsersRepository.save(newUser);
		Iterable<TimeTrackUsers> users = timeTrackUsersRepository.findAll();
		for (TimeTrackUsers user : users) {
			System.out.println(user.getFirstName());
			usersList.add(user);
		}
		return usersList;
	}

	public @RequestMapping("/searchuser") TimeTrackUsers searchUser(
			@RequestParam(value = "user", required = true) String userParam) {
		List<TimeTrackUsers> users = timeTrackUsersRepository
				.findByFirstNameLike(userParam.toLowerCase());

		TimeTrackUsers user = null;
		if (null != users && !users.isEmpty()) {
			user = users.get(0);
		}

		return user;
	}

}
