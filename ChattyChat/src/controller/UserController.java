package controller;

import java.util.ArrayList;
import java.util.HashSet;
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
	private String name;
	private String chatTopic = "";
	private List<Chat> chats;
	private Chat chat;
	
	public UserController(){
		
	}

	public String addUser() {
		chats = new ArrayList<Chat>(Lobby.getInstance().getChats());

		for (Chat c : chats) {
			if (c.getName().equals(chatTopic)) {
				chat = c;
			}
		}
		users = chat.getUsers();
		names = new HashSet<String>();
		names = getUserNames();

		User newUser = new User(name);

		if (!users.contains(newUser)) {
			users.add(newUser);
			names.add(newUser.getName());

			if (!("".equals(chatTopic))) {
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(true);
				session.setAttribute("username", name);
				session.setAttribute("chat", chatTopic);
				return "chat?faces-redirect=true";
			} else {
				// TODO: error
				System.out.println("Please select chat topic!!");
			}
		} else {
			// TODO: error
			System.out.println("name already taken!");
		}
		return "";

	}

	public Set<User> getUsers() {
		return users;
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

	public String getChatTopic() {
		return chatTopic;
	}

	public void setChatTopic(String chatTopic) {
		this.chatTopic = chatTopic;
	}

	public List<Chat> getChats() {
		chats = new ArrayList<Chat>(Lobby.getInstance().getChats());
		return chats;
	}
	
	public void setChats(List<Chat> list){
		this.chats = list;
	}

}
