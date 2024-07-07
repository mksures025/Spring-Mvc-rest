package com.te.loginpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.te.loginpage.dto.LoginDTO;

import com.te.loginpage.service.LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/loginC")
@Controller
public class loginController {

	private final LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {

		System.out.println("Reached login page");

		return "login";

	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDTO loginDTO) {

		System.out.println("Reached Request page");

		boolean login = loginService.login(loginDTO);

		if (login) {
			return "welcome";
		} else
			return "login";

	}

}
