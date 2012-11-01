package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class ChatTopic {

    private String text; 
    private List<String> items;

	@PostConstruct
    public void init() {
        items = new ArrayList<String>();
        items.add("Chat - Topic 1");
        items.add("Chat - Topic 2");
    }

    public void add() {
        items.add(text);
    }

    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getItems() {
		return items;
	}
}