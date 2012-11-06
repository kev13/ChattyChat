package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.faces.event.ActionEvent;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date date;
	private String content;
	private User user;

	public Message() {
	}

	public String getDate() {
		return DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return getDate() + " " + user.getName() + ": " + content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user.getName();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void sendMessage(ActionEvent e) {
		date = new Date();
	}

	public String getColor() {
		Color c = user.getColor();
		return "color: rgb(" + c.red + "," + c.green + "," + c.blue + ")";
	}
}
