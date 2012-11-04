package controller;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Chat;
import model.Lobby;
import model.User;

@ManagedBean
@SessionScoped
public class UserController {
	private Set<User> users;
	private Set<String> names;
	private String name;
	private String chatTopic = "";
	private Chat chat = new Chat("test");
	
	public void addUser(){
		users = chat.getUsers();
		names = new HashSet<String>();
		names = getUserNames();
		
		User newUser = new User(name);
		
		
		if (!users.contains(newUser))
		{
			users.add(newUser);
			names.add(newUser.getName());
			
			if ( !("".equals(chatTopic)) ){
				System.out.println("user: " + name + " selected chat: " + chatTopic);
				//Set<Chat> chats = Lobby.getInstance().getChats();
				
				
			} else {
				//TODO: error
				System.out.println("Please select chat topic!!");
			}
			
			
		} else {
			
			//TODO: error
			System.out.println("name already taken!");
		}
		
		
		
		
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public Set<String> getUserNames(){
		Set<String> temp = this.names;
		
		for (User u : users){
			temp.add(u.getName());
		}
		
		return temp;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getNames() {
		return names;
	}

	public void setNames(Set<String> names) {
		this.names = names;
	}

	public String getChatTopic() {
		return chatTopic;
	}

	public void setChatTopic(String chatTopic) {
		this.chatTopic = chatTopic;
	}
	
	
	
	
}
