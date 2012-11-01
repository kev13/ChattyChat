package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chat {

	private String name;
	private Set<User> users;
	private List<Message> history;

	public Chat() {
		name = "default";
		history = new ArrayList<Message>();
		users = new HashSet<User>();
	}
	
	public Chat(String name){
		this.name = name;
		history = new ArrayList<Message>();
		users = new HashSet<User>();
	}
		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public List<Message> getHistory() {
		return history;
	}

}
