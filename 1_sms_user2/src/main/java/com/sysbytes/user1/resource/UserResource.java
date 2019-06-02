package com.sysbytes.user1.resource;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	private static final Logger LOG = Logger.getLogger(UserResource.class.getName());
	@Value("${welcomemessage:dev dev}")
	private String message;
	
	@Autowired
	private UserService userService;
	@GetMapping(value="/users")

	public List<User> getUsers() {
		 LOG.log(Level.INFO, "In get users "+message);
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getSingleUser(@PathVariable Long id) {
		return userService.getSingleUser(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		 LOG.log(Level.INFO, "In Create User");
		userService.createUser(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable(name="id") Long userid) {
		userService.deleteUser(userid);
		return ResponseEntity.ok().build();
	}
	

}
