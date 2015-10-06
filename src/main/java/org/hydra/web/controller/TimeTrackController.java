package org.hydra.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeTrackController {
	public @RequestMapping("/innovation") String getInnovationPage() {
		return "innovation";
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
