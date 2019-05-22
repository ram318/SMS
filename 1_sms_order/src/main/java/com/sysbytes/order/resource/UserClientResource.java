package com.sysbytes.order.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserClientResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	/*
		public UserClientResource(RestTemplate restTemplate){
		
			this.restTemplate = restTemplate;
		}

	 */
	
	@GetMapping("/users")
	public List getUsers() {
		List userList = restTemplate.getForObject("http://userms/users", List.class);
				return userList;
	}

}
