package com.springbootstudy.main.ui.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstudy.main.model.User;
import com.springbootstudy.main.model.UserDto;
import com.springbootstudy.main.services.IUserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	private User userReturned;
	private IUserService userService;

	@PostMapping
	public User createUsers(@RequestBody User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		userDto.setUserId(passwordEncoder.encode(user.getUsername()));
		userDto.setPassword(passwordEncoder.encode(user.getPassword()));
		userReturned = new User();
		BeanUtils.copyProperties(userService.createUser(userDto), userReturned);
		return userReturned;
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		UserDto dto = userService.getUser(username);
		userReturned = new User();
		BeanUtils.copyProperties(dto, userReturned);
		return userReturned;
	}

	@GetMapping("/hello")
	public String getUserHello() {
		return "hello";
	}
}
