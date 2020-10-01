package com.springbootstudy.main.services;

import com.springbootstudy.main.model.UserDto;

public interface IUserService {

	public UserDto createUser(UserDto userDto);

	public UserDto getUser(String emailId);

}
