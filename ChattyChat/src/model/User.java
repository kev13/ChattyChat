package model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public Chat activeChat;

	public User() {

	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chat getActiveChat() {
		return activeChat;
	}

	public void setActiveChat(Chat activeChat) {
		this.activeChat = activeChat;
	}
}
