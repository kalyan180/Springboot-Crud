package com.springboot.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.crud.entity.UserEntity;
import com.springboot.crud.model.User;
import com.springboot.crud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	private static List<User> list= new ArrayList<>();
	
	//private List<User> userDataList=
	
	
	@Override
	public List<UserEntity> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(Integer id) {
		Optional<UserEntity> getUser=userRepository.findById(id);
		if(getUser.isPresent()) {
			UserEntity userDetails=getUser.get();
		return userDetails;
		} 
		return null;
	}

	@Override
	public String deleteUser(Integer id) {
		Optional<UserEntity> deleteUser=userRepository.findById(id);
		if(deleteUser.isPresent()) {
			userRepository.delete(deleteUser.get());
		}
		return "success";
	}

	@Override
	public UserEntity createUser(UserEntity user) throws Exception {
		userRepository.save(user);
		return null;
	}

	/*
	 * @Override public UserEntity updateUser(User user) { Optional<UserEntity>
	 * getUser=userRepository.findById(user.getU_id()); if(getUser.isPresent()) {
	 * 
	 * UserEntity userUpdate=getUser.get(); 
	 * userUpdate.setU_id(user.getU_id());
	 * userUpdate.setU_email(user.getU_email());
	 * userUpdate.setU_mobile(user.getU_mobile());
	 * userUpdate.setU_name(user.getU_name());
	 * userUpdate.setU_real_id(user.getU_id());
	 * 
	 * userRepository.save(userUpdate); return
	 * userRepository.getById(user.getU_id()); } return null; }
	 * 
	 * 
	 * 
	 * list =(List<User>) list.stream().map(b->{
			if(b.getU_id()==id)
			{
				b.setU_id(user.getU_id());
				b.setU_email(user.getU_email());
				b.setU_mobile(user.getU_mobile());
				b.setU_name(user.getU_name());
				b.setU_real_id(user.getU_real_id());
			}
			
			return b;
		}).collect(Collectors.toList());
	
		
	
	 */

	@Override
	public UserEntity updateUser(User user,Integer id) {
		Optional<UserEntity> getUser=userRepository.findById(id);
		if(getUser.isPresent()) {
			UserEntity userUpdate=getUser.get();
			userUpdate.setU_id(user.getU_id());
			  userUpdate.setU_email(user.getU_email());
			  userUpdate.setU_mobile(user.getU_mobile());
			  userUpdate.setU_name(user.getU_name());
			  userUpdate.setU_real_id(user.getU_id());
			
			userRepository.save(userUpdate);
			return userUpdate;
		}
		return null;

	}
}
	
