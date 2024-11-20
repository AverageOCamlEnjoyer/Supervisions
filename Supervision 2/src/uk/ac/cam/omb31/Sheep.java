package uk.ac.cam.omb31;

public class Sheep extends Animal implements Cloneable {
	public Sheep(String name) throws CloneNotSupportedException {
		super(name);
	}
	
	public void speak() {
		System.out.println("baaa");
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Sheep) super.clone();
	}
}
