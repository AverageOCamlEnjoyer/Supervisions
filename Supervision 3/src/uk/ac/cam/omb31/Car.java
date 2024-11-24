package uk.ac.cam.omb31;

import java.util.Set;
import java.util.TreeSet;

public class Car implements Comparable<Car>{
	private String manufactuer;
	private int age;
	@Override
	public int compareTo(Car c) {
		int compareManufactuer = manufactuer.compareTo(c.manufactuer);
		
		if (compareManufactuer != 0) {
			return compareManufactuer;
		} else {
			if (age > c.age) {
				return 1;
			} else if (age < c.age){
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Set<Car> cars = new TreeSet<Car>();
	}

}
