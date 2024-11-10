public class Stack {
	Element head = null;
 	public void push(int value) {
		Element newElement = new Element(value);
		if (head == null) {
			head = newElement;
			return;
		} else {
			newElement.setPointer(head);
		}
	}
	public int pop() {
		if (head == null) {
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}
		int value = head.getValue();
		head = head.getPointer();
		return value;
		
	}
}
