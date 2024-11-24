package uk.ac.cam.omb31;

public class StaticExample {
	private static String staticField = "Static Field";

	public static void staticMethod() {
		System.out.println(staticField);
	}
	
	public static void main(String[] args) {
		//Static usage
		StaticExample.staticMethod();
		StaticExample.staticField = "Update";
		//Non static usage
		NonStaticExample obj = new NonStaticExample();
		obj.nonStaticMethod();
		obj.nonStaticField = "Update";
	}

}


