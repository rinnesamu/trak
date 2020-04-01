package stackwithlinkedlist;

import java.util.LinkedList;

public class Stack {
	
	private LinkedList<ListItem> list;
	 public Stack() {
	 list = new LinkedList<ListItem>();
	 }

	
	// adds new element to stack
	public void push(String aData) {
		ListItem item = new ListItem();
		item.setData(aData);
		list.add(item);
	}

	// returns and deletes element from stack
	// returns null if no elements in stack
	public ListItem pop() {
		ListItem item = null;
		if (list.size() != 0) {
			item = list.removeLast();
		}
		return item;
	}
	
	// prints stack elements
	public void printItems() {
		if (list.size() != 0) {
			for (int i = list.size()-1; i >= 0; i--) {
				System.out.println(list.get(i).getData());
			}
		}else{
			System.out.println("Pino on tyhjä!");
		}
	}
	
	public int getSize() {
		return list.size();
	}
}
