package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Chat;
import model.Message;
import model.User;

@ManagedBean
@SessionScoped
public class MessageController {
	private Chat chat;
	private List<Message> history;
	private Set<User> users;
	private String content;
	private String username;

	public MessageController() {
		chat = new Chat();
		history = chat.getHistory();
		users = chat.getUsers();
		User u = new User();
		u.setName("ueli");
		users.add(u);
		username = u.getName();
	}

	public void sendMessage(ActionEvent e) {
		if (content != null) {
			Message m = new Message();
			m.setContent(content);
			m.setDate(new Date());
			history.add(m);
		}
	}

	public List<Message> getHistory() {
		return history;
	}
	
	public List<User> getUsers(){
		return new ArrayList<User>(users);
	}

	public String getContent() {
		return content;
	}
	
	public String getUsername(){
		return username;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void addUser(User u){
		users.add(u);
	}

}
