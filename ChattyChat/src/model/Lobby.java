package model;

import java.util.HashSet;
import java.util.Set;

public class Lobby {
	
	private static Lobby instance = null;
	private static Set<Chat> chats;

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
	            chats = new HashSet<Chat>();
	            chats.add(new Chat("Chat - Topic 1"));
	            chats.add(new Chat("Chat - Topic 2"));
	        }
	        
	        return instance;
	 }
	
}
