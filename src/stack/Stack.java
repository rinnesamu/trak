package stack;

public class Stack {
	private ListItem top = null;
	private int size = 0;
	
	// adds new element to stack
	public void push(String aData) {
		ListItem l = new ListItem();
		l.setData(aData);
		l.setNext(top);
		top = l;
		size++;
		
	}

	// returns and deletes element from stack
	// returns null if no elements in stack
	public ListItem pop() {
		ListItem returnListItem = null;
		if (this.size != 0) {
			ListItem temp = top.getNext();
			size--;
			returnListItem = top;
			top = temp;
		}
		return returnListItem;
	}
	
	// prints stack elements
	public void printItems() {
		ListItem l = top;
		while (l != null) {
			System.out.println(l.getData());
			l = l.getNext();
		}
		
	}
	
	public int getSize() {
		return this.size;
	}
}
