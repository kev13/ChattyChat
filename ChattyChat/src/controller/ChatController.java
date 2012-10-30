package controller;

import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Chat;
import model.Lobby;

@ManagedBean
@ApplicationScoped
public class ChatController {
	private Lobby lobby;
	private Set<Chat> chats;

	public ChatController(){
		lobby = Lobby.getInstance();
		chats = lobby.getChats();
	}
	
	public void addChat(){
		Chat newChat = new Chat("newChat");
		chats.add(newChat);
	}
	
	public Set<Chat> getChats() {
		return chats;
	}

	
	
	
	
	
}
