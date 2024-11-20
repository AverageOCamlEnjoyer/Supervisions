package uk.ac.cam.omb31;

public abstract class Animal {
	protected String name;
	public Animal(String name) {
		this.name = name;
	}
	protected abstract void speak();
}


