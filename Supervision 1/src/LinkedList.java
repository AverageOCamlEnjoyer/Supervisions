import java.util.HashSet;

public class LinkedList {
	Element head = null;
 	public void addElement(int value) {
		Element newElement = new Element(value);
		Element current = head;
		boolean added = false;
		if (head == null) {
			head = newElement;
			return;
		}
		Element pointer = head.getPointer();
		do {
			if (pointer == null) {
				current.setPointer(newElement);
				added = true;
			} else {
				Element temp = pointer;
				current = pointer;
				pointer = temp.getPointer();
			}	
		} while (!added);
		
	}
	public int getHead() {
		return head.getValue();
	}
	public void remove(int index) {
		int i = 0;
		Element current = head;
		//Special case
		if (index == 0) {
			this.head = head.getPointer();
			return;
		}
		
		while (i < index) {
			if ((i+1) == index) {
				//Change pointer to skip the next element
				current.setPointer((current.getPointer()).getPointer());
				return;
			}
			current = current.getPointer();
			i += 1;
		}
	}
	public int length() {
		Element current = head;
		if (head == null) {
			return 0;
		}
		int length = 1;
		while (current.getPointer() != null) {
			current = current.getPointer();
			length++;
		}
		return length;
	}
	public int getNth(int n) {
		Element current = head;
		int length = length();
		if ((n+1) > length) {
			throw new ArrayIndexOutOfBoundsException("List Index Out of Bounds");
		}
		for (int i = 0; i < n; i++) {
			current = current.getPointer();
		}
		return current.getValue();
	}
	public boolean hasCycle() {
		HashSet<Element> refrences = new HashSet<Element>();
		if (head == null) {
			return false;
		}
		Element current = head;
		while (current != null) {
			if (refrences.contains(current)) {
				return true;
			}
			refrences.add(current);
			current = current.getPointer();
		}
		return false;
	}
	public static void printList(LinkedList a) {
		int length = a.length();
		for (int i = 0; i < length; i++) {
			System.out.print(a.getNth(i)+",");
		}
		System.out.println();
	}

}
