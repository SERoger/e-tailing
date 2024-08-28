package com.crow.user.service;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import com.crow.user.dto.SigninRequest;
import com.crow.user.dto.SignupDto;
import com.crow.user.model.User;

public interface IUserService {
	User create(SignupDto signupDto) throws ResponseStatusException;
	List<User> get();
	User signin(SigninRequest signinRequest);
}
