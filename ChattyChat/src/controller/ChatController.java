package controller;

import java.util.HashSet;
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
	private Set<String> chatTopics;

	public ChatController(){
		lobby = Lobby.getInstance();
		chats = lobby.getChats();
		System.out.println("init");
		chatTopics = new HashSet<String>();
		chatTopics = getChatNames();
	}
	
	public void addChat(){
		lobby = Lobby.getInstance();
		chats = lobby.getChats();
		chatTopics = new HashSet<String>();
		chatTopics = getChatNames();
		
		
		Chat newChat = new Chat(chatTopic);
		
		if (!chats.contains(newChat)){
			//chats.add(newChat);
			lobby.addChat(newChat);
			if (!chatTopics.contains(newChat.getName()))
			{
				chatTopics.add(newChat.getName());
			}
		}
		
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
	
	public Set<String> getChatTopics() {
		return chatTopics;
	}

	public void setChatTopics(Set<String> chatTopics) {
		this.chatTopics = chatTopics;
	}

	public Set<String> getChatNames(){
		Set<String> temp = this.chatTopics;
		
		for (Chat ch : chats){
			temp.add(ch.getName());
			System.out.println("name: "+ ch.getName());
		}
		return temp;
	}	
	
	
}
