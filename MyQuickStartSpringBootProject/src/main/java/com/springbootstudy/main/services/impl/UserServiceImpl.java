package com.springbootstudy.main.services.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootstudy.main.model.UserDto;
import com.springbootstudy.main.model.entities.UserEntity;
import com.springbootstudy.main.repository.UserRepository;
import com.springbootstudy.main.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setDateUserAdded(new Date());

		UserEntity userEntityReturned = userRepository.save(userEntity);
		UserDto userDtoReturned = new UserDto();
		BeanUtils.copyProperties(userEntityReturned, userDtoReturned);
		return userDtoReturned;
	}

	@Override
	public UserDto getUser(String emailId) {
		Optional<UserEntity> user = userRepository.findUserByEmailId(emailId);
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}

}
