package controller;

import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Chat;
import model.Lobby;

@ManagedBean
@ApplicationScoped
public class ChatController {
	private int chatNumber;
	private String chatTopic;
	private Lobby lobby;
	private Set<Chat> chats;

	public ChatController(){
		lobby = Lobby.getInstance();
		chats = lobby.getChats();
	}
	
	public void addChat(){
		Chat newChat = new Chat(chatTopic);
		chats.add(newChat);
	}
	
	public Set<Chat> getChats() {
		return chats;
	}

	public int getChatNumber() {
		return chatNumber;
	}

	public void setChatNumber(int chatNumber) {
		this.chatNumber = chatNumber;
	}

	public String getChatTopic() {
		return chatTopic;
	}

	public void setChatTopic(String chatTopic) {
		this.chatTopic = chatTopic;
	}
	
	
	
	
	
}
