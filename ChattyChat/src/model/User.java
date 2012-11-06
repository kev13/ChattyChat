package model;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Color color;

	public User() {
		Random randomGenerator = new Random();
		color.blue = randomGenerator.nextInt(255);
		color.green = randomGenerator.nextInt(255);
		color.red = randomGenerator.nextInt(255);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
