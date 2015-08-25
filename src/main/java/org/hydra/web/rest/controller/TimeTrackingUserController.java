package org.hydra.web.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.hydra.timetrack.db.beans.InnovationTimeTracking;
import org.hydra.timetrack.db.beans.TimeTrackUsers;
import org.hydra.timetrack.db.repository.InnovationTimeTrackingRepository;
import org.hydra.timetrack.db.repository.TimeTrackUsersRepository;
import org.hydra.web.rest.response.json.BaseJsonResponse;
import org.hydra.web.rest.response.json.TimeTrackingUsersJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeTrackingUserController {
	@Autowired
	private TimeTrackUsersRepository timeTrackUsersRepository;

	@Autowired
	private InnovationTimeTrackingRepository trackingRepository;

	@RequestMapping("/users")
	public List<TimeTrackUsers> getUsers() {
		List<TimeTrackUsers> usersList = new ArrayList<TimeTrackUsers>();
		TimeTrackUsers newUser = new TimeTrackUsers();
		newUser.setEmail("htomar@sapient.com");
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

	public @RequestMapping("/innovation/searchUser") TimeTrackingUsersJson searchUser(
			@RequestParam(value = "email", required = true) String email) {
		TimeTrackingUsersJson jsonResponse = new TimeTrackingUsersJson(
				BaseJsonResponse.ResponseStatus.OK);
		List<TimeTrackUsers> users = timeTrackUsersRepository
				.findByEmailLike(email);
		jsonResponse.setTimeTrackUsers(users);
		return jsonResponse;
	}

	public @RequestMapping(value = "/innovation/updateDetails", method = RequestMethod.GET) BaseJsonResponse updateDetails(
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "week", required = true) long week,
			@RequestParam(value = "effort", required = true) long effort) {
		BaseJsonResponse jsonResponse = new BaseJsonResponse(
				BaseJsonResponse.ResponseStatus.OK);
		if (null == email) {
			jsonResponse.setStatus(BaseJsonResponse.ResponseStatus.ERROR);
			jsonResponse.setMessage(BaseJsonResponse.DEFAULT_ERROR_MSG);
		} else {
			TimeTrackUsers users = timeTrackUsersRepository.findByEmail(email);
			if (null == users) {
				jsonResponse.setStatus(BaseJsonResponse.ResponseStatus.ERROR);
				jsonResponse.setMessage("Invalid email id provided.");
			} else {
				InnovationTimeTracking innTimeTracking = trackingRepository
						.findByEmailAndWeek(email, week);
				if (null == innTimeTracking) {
					innTimeTracking = new InnovationTimeTracking();
					innTimeTracking.setEmail(email);
					innTimeTracking.setWeek(week);
				}
				innTimeTracking.setEffort(effort);
				trackingRepository.save(innTimeTracking);
			}
		}
		return jsonResponse;
	}
}
