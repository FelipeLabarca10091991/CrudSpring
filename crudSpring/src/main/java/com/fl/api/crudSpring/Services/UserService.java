package com.fl.api.crudSpring.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fl.api.crudSpring.Models.UserModel;
import com.fl.api.crudSpring.Repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepository;
	
	public ArrayList<UserModel> getUsers()
	{
		return (ArrayList<UserModel>) userRepository.findAll();
	}
	
	public UserModel saveUser(UserModel user) 
	{
		return userRepository.save(user);
	}

	//Este tipo de dato es Optional porque puede venir o un objeto o un null;
	public Optional<UserModel> getById(Long id)
	{
		return userRepository.findById(id);
	}
	
	public UserModel updateById(UserModel request, Long id)
	{
		UserModel user = userRepository.findById(id).get();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		
		return user;
	}
	
	public Boolean deteleUser(Long id)
	{
		try {
			userRepository.deleteById(id);
			return true;
		}catch(Exception e ) {
			return false;
		}
	}
}
