package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Chat;
import model.User;

@ManagedBean
@SessionScoped
public class UserController {
	private Set<User> users;
	private String name;
	private Chat chat = new Chat("test");
	
	public void addUser(){
		users = chat.getUsers();
		User newUser = new User(name);
		
		
		if (!users.contains(newUser))
		{
			users.add(newUser);
			
		} else {
			
			//TODO: error
		}
		
		
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
