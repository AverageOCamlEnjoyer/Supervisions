package uk.ac.cam.omb31;

public class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	protected void speak() {
		System.out.println("Meow");
	}
}
