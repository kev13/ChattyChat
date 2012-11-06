package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
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
	private List<Chat> chats;

	private String name;
	private String chatTopic;

	private Chat chat;

	public UserController() {

	}

	private void updateData() {
		chats = new ArrayList<Chat>(Lobby.getInstance().getChats());

		for (Chat c : chats) {
			if (c.getName().equals(chatTopic)) {
				chat = c;
			}
		}
	}

	private boolean addUser() {
		updateData();
		
		if ("".equals(chatTopic)) {
			FacesContext.getCurrentInstance().addMessage(
					"chat topic:",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please select chat topic!!", ""));
			System.out.println("Please select chat topic!!");
			return false;
		}
		
		users = chat.getUsers();

		for (User u : users) {
			if (name.equals(u.getName())) {
				FacesContext.getCurrentInstance().addMessage(
						"duplicate name",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"name already taken, please use another!", ""));
				System.out.println("name already taken!");
				return false;
			}
		}
		User newUser = new User(name);
		users.add(newUser);
		

		
		return true;

		
	}

	public String joinChat() {
		if (addUser()) {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("username", name);
			session.setAttribute("chat", chatTopic);
			return "chat?faces-redirect=true";
		} else {
			return "";
		}
	}

	public List<User> getUsers() {
		updateData();
		if (chat == null)
			return null;
		return new ArrayList<User>(chat.getUsers());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
