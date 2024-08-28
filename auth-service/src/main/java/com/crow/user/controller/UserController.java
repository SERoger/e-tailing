package com.crow.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.crow.user.dto.SigninRequest;
import com.crow.user.dto.SignupDto;
import com.crow.user.service.IUserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	IUserService userService;

	@PostMapping({"/signup"})
	public ResponseEntity<?> createEmp(@RequestBody SignupDto signupDto)  throws ResponseStatusException{
		return new ResponseEntity<>(userService.create(signupDto), HttpStatus.CREATED);
	}
	
	@GetMapping({"/all"})
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(userService.get(), HttpStatus.OK);
	}

	@PostMapping({"/signin"})
	public ResponseEntity<?> login( @RequestBody SigninRequest signinRequest) throws ResponseStatusException {
		System.out.println(signinRequest.getUserName());
		return new ResponseEntity<>(userService.signin(signinRequest), HttpStatus.ACCEPTED);
	}

	
}
