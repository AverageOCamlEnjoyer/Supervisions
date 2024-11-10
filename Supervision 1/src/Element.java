
public class Element {
	int value;
	Element pointer = null;
	public Element(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public Element getPointer(){
		return this.pointer;
	}
	public void setPointer(Element newPointer) {
		this.pointer = newPointer;
	}
}
