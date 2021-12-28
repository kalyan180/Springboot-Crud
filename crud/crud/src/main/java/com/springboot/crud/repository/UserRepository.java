package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
}
