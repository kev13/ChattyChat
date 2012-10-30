package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.faces.event.ActionEvent;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String content;
	private User user = new User("ueli");

	public Message() {

	}

	public String getDate() {
		return DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
		//return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user.getName();
		//return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void sendMessage(ActionEvent e) {
		date = new Date();
	}

}
