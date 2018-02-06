package net.anviprojects.SpringMVCProject.mvc.excelpdf;

public class Cat {
	private String name;
	private String color;
	private int weight;

	public Cat(String name, String color, int weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getWeight() {
		return weight;
	}
}
