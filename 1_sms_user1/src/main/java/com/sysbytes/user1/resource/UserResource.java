package com.sysbytes.user1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysbytes.user1.model.User;
import com.sysbytes.user1.service.UserService;


@RestController
public class UserResource {
	
	@Autowired
	private UserService userService;
	@GetMapping(value="/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getSingleUser(@PathVariable Long id) {
		return userService.getSingleUser(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		userService.createUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable(name="id") Long userid) {
		userService.deleteUser(userid);
		return ResponseEntity.ok().build();
	}
	

}
