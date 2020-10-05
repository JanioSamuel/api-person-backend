package com.api.pessoa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("https://api-person-frontend.herokuapp.com/")
public class ApplicationController {


	@RequestMapping(value = "/source", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getGithubLink() {
		Map<String, String> sources = new HashMap<>();
		sources.put("backend", "https://github.com/JanioSamuel/api-person-backend");
		sources.put("frontend", "https://github.com/JanioSamuel/api-person-frontend");
		return sources;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ResponseEntity.ok(auth.isAuthenticated());
	}
}
