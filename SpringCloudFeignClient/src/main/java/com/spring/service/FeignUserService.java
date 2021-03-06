package com.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.model.User;

@FeignClient(name = "${service-name}", url = "${service.base.url}")
public interface FeignUserService {

	@GetMapping(value = "/user/{email}")
	User getUser(@PathVariable String email);

	@PutMapping(value = "/user")
	public void updateUser(@RequestBody User user);

	@PostMapping(value = "/user")
	public void addUser(@RequestBody User user);

	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable Integer id);

}
