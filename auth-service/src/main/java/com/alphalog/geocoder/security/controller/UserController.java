package com.alphalog.geocoder.security.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alphalog.geocoder.security.domain.Users;
import com.alphalog.geocoder.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Users getUser(Principal principal) {
		return   ((Users)((OAuth2Authentication) principal).getUserAuthentication().getPrincipal());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody Users user) {
		userService.create(user);
	}
}
