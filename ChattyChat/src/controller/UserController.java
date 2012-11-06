package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Chat;
import model.Lobby;
import model.User;

@ManagedBean
@SessionScoped
public class UserController {
	private Set<User> users;
	private Set<String> names;
	private List<Chat> chats;
	
	private String name;
	private String chatTopic;
	
	private Chat chat;
	
	public UserController(){
		
	}
	
	private void updateData(){
		chats = new ArrayList<Chat>(Lobby.getInstance().getChats());

		for (Chat c : chats) {
			if (c.getName().equals(chatTopic)) {
				chat = c;
			}
		}
	}
	
	private boolean addUser(){
		updateData();
		users = chat.getUsers();
		User newUser = new User(name);

		if (!users.contains(newUser)) {
			users.add(newUser);
			if (!("".equals(chatTopic))) {
				return true;
			} else {
				// TODO: error
				System.out.println("Please select chat topic!!");
			}
		} else {
			// TODO: error
			System.out.println("name already taken!");
		}
		return false;
	}

	public String joinChat() {
		if(addUser()){
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(true);
			session.setAttribute("username", name);
			session.setAttribute("chat", chatTopic);
			return "chat?faces-redirect=true";
		} else{
			return "";
		}
	}

	public List<User> getUsers() {
		updateData();
		if(chat == null)
			return null;
		return new ArrayList<User>(chat.getUsers());
	}

	public Set<String> getUserNames() {
		Set<String> temp = this.names;

		for (User u : users) {
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

	public List<Chat> getChats() {
		chats = new ArrayList<Chat>(Lobby.getInstance().getChats());
		return chats;
	}

	public String getChatTopic() {
		return chatTopic;
	}

	public void setChatTopic(String chatTopic) {
		updateData();
		this.chatTopic = chatTopic;
	}

}
