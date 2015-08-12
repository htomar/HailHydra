package org.hydra.web.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value = PATH)
	public String error() {
		return "error";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
