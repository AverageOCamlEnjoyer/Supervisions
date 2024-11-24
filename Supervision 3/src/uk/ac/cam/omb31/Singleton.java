package uk.ac.cam.omb31;

public class Singleton {
	private static Singleton instance = null;
	public static Singleton getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new Singleton();
			return instance;
		}
	}
	private Singleton() {
		System.out.println("Create instance if one doesn't exsist");
	}
}


