package model;

import java.util.Set;

public class Lobby {
	
	private static Lobby instance = null;
	private Set<Chat> chats;

	private Lobby() {}
	
	public Set<Chat> getChats() {
		return chats;
	}
	
	public void addChat(Chat chat){
		chats.add(chat);
	}
	
	 public static synchronized Lobby getInstance() {
	        if (instance == null) {
	            instance = new Lobby();
	        }
	        
	        return instance;
	 }
	
}
