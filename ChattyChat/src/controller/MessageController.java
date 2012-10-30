package controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Chat;
import model.Message;

@ManagedBean
@SessionScoped
public class MessageController {
	private Chat chat;
	private List<Message> history;
	private String content;

	public MessageController() {
		chat = new Chat();
		history = chat.getHistory();
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
		return chat.getHistory();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
