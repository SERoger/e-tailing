package com.crow.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.crow.user.dto.SigninRequest;
import com.crow.user.dto.SignupDto;
import com.crow.user.exception.UserAlreadyExistException;
import com.crow.user.model.EAccess;
import com.crow.user.model.ERole;
import com.crow.user.model.User;
import com.crow.user.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User create(SignupDto signupDto)  throws ResponseStatusException{
		if(isUser(signupDto.getUserName())) {
			throw new ResponseStatusException(HttpStatus.FOUND,"Username in use");
		}
		User u=new User();
		u.setId(UUID.randomUUID());
		u.setFullName(signupDto.getFullName());
		u.setUserName(signupDto.getUserName());
		u.setPassword(signupDto.getPassword());
		u.setRole(ERole.valueOf(signupDto.getRole()));
		u.setAccess(EAccess.ON);
		return userRepository.save(u);
	}

	public boolean isUser(String userName) {
		return userRepository.findByUserName(userName).isPresent();
	}

	@Override
	public List<User> get() {
		return userRepository.findAll();
	}

	@Override
	public User signin(SigninRequest signinRequest) throws UserAlreadyExistException {
		Optional<User> user = userRepository.findByUserName(signinRequest.getUserName());
		if (!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
		}
		if (user.get().getAccess().equals(EAccess.OFF)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "not autorized");
		} 
		if (!user.get().getPassword().equals(signinRequest.getPassword())) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "inputs doesn't match");
		} else {
			return user.get();
		}
	}

}
