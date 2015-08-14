package org.hydra.web.controller;

import org.hydra.timetrack.db.repository.TimeTrackUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeTrackController {
	@Autowired
	private TimeTrackUsersRepository timeTrackUsersRepository;

	public @RequestMapping("/innovation") String getInnovationPage() {
		return "timetracking/innovation";
	}

	public @RequestMapping("/temp") String temp(
			@RequestParam(value = "user", required = false) String userParam) {
		if (null == userParam || userParam.isEmpty()) {
			System.out.println("Empty");
			return "failed";
		}
		return "passed";
	}
}
