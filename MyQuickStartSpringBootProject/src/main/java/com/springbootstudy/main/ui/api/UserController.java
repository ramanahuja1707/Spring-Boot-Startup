package com.springbootstudy.main.ui.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	private IUserService userService;

	@PostMapping
	public User createUsers(@RequestBody User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		userDto.setEncryptedPassword(user.getPassword().hashCode() + "");
		userDto.setRecoverEmailAddress("");
		User userReturned = new User();
		BeanUtils.copyProperties(userService.createUser(userDto), userReturned);
		return userReturned;
	}

	@GetMapping("/{emailId}")
	public String getUser(@PathVariable String emailId) {
		UserDto dto = userService.getUser(emailId);
		System.out.println(dto.getUserName());
		return dto.getUserName();
	}
}
