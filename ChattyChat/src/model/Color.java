package model;

import java.io.Serializable;
import java.util.Random;

public class Color implements Serializable {
	private static final long serialVersionUID = 1L;
	public int red;
	public int green;
	public int blue;

	public Color() {
		Random randomGenerator = new Random();
		blue = randomGenerator.nextInt(255);
		green = randomGenerator.nextInt(255);
		red = randomGenerator.nextInt(255);
	}
}
