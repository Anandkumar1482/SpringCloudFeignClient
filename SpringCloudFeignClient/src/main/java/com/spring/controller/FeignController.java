package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.FeignUserService;

@RestController
public class FeignController {

	@Autowired
	FeignUserService feignUserService;

	@GetMapping(value = "/cc")
	@ResponseBody
	public String name() {
		return "feignClient";
	}

	@GetMapping(value = "/user/{email}")
	public User getSingleUser(@PathVariable String email) {
		return feignUserService.getUser(email);

	}

	@PutMapping(value = "/user")
	public void allUsers(@RequestBody User user) {
		feignUserService.updateUser(user);
	}

	@PostMapping(value = "/user")
	public void addUser(@RequestBody User user) {
		feignUserService.addUser(user);
	}

	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		feignUserService.deleteUser(id);
	}
}
