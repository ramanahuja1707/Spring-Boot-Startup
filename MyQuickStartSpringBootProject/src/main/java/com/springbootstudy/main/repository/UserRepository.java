package com.springbootstudy.main.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootstudy.main.model.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	public Optional<UserEntity> findUserByUserId(String emailId);

	public Optional<UserEntity> findUserByUsername(String username);

}
