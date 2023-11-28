package com.fl.api.crudSpring.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fl.api.crudSpring.Models.UserModel;
import com.fl.api.crudSpring.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ArrayList<UserModel> getUsers()
	{
		return this.userService.getUsers();
	}
	
	//Postmapping indica metodo POST. Requestbody indica que el argumento viene en el body.
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) 
	{
		return this.userService.saveUser(user);
	}
	
	//Getmapping indica metodo GET. pathvariable indica que el argumento viene en la url y cae en /user/${id}
	@GetMapping(path = "$/{id}")
	public Optional<UserModel> getUserById(@PathVariable("id") Long id)
	{
		return this.userService.getById(id);
	}

	@PutMapping(path = "$/{id}")
	public UserModel updateUserById(@RequestBody UserModel request,@PathVariable("id") Long id)
	{
		return this.userService.updateById(request, id);
	}
	
	@DeleteMapping(path = "$/{id}")
	public String deleteUserById(@PathVariable Long id)
	{
		boolean ok =  this.userService.deteleUser(id);
		
		if (ok) {
			return "User with id " + id + " deleted ";
		}else {
			return "Error";
		}
	}
	
}
