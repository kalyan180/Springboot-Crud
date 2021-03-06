package com.springboot.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.crud.entity.UserEntity;
import com.springboot.crud.model.User;

@Service
public interface UserService {
	
	List<UserEntity> getUsers();
	
	UserEntity getUserById(Integer userEntity);
	
	String deleteUser(Integer id);
	
	UserEntity createUser(UserEntity user)throws Exception;
	
	//UserEntity updateUser(User user);

   public UserEntity updateUser(User user,Integer id);
    


}
