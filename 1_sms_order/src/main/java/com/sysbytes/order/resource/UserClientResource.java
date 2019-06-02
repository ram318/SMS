package com.sysbytes.order.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserClientResource {

	@Autowired
	@LoadBalanced // client side load balancing for ribbon 
	private RestTemplate restTemplate;

	@GetMapping("/users")
	public List<?> getUsers() {
		List<?> userList = restTemplate.getForObject("http://userms/users", List.class);
		return userList;
	}

	@GetMapping("/users/{id}")
	public String getUserWithId(@PathVariable Long id) {
		return restTemplate.getForObject("http://userms/users/" + id, String.class);		
	}

}
