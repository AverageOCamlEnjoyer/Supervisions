package uk.ac.cam.omb31;

public class Dog extends Animal implements Trainable {
	private String breed;
	public static void main(String[] args) {
		
		Dog myDog = new Dog("Pug","Peggy");
		Animal myPet = null;
		myPet = (Animal) myDog;
		myPet.speak();
		
//		Animal myPet = null;
//		if (args[0] == "Dog") {
//			Dog myDog = new Dog("Pug","Peggy");
//			myPet = (Animal) myDog;
//		} else {
//			Cat myCat = new Cat("B");
//			myPet = (Animal) myCat;
//		}
//		myPet.speak();
		
	}
	
	public Dog(String breed, String name) {
		super(name);
		this.breed = breed;
	}
	
	@Override
	protected void speak() {
		System.out.println("Woof");
	}
	
	@Override
	public void sit(){
		speak();
	}
}



