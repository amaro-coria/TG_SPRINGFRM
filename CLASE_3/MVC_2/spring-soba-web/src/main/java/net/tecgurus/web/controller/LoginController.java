package net.tecgurus.web.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(Map<String, Object> model) {
		log.debug("login() is executed!");
		return "login/login";
	}

}
