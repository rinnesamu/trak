package stackwithlinkedlist;

import java.util.Iterator;
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
		ListItem item;
		for (Iterator i = list.descendingIterator(); i.hasNext();) {
			item = (ListItem)i.next();
	        System.out.println(item.getData());
	      }
	}
	
	public int getSize() {
		return list.size();
	}
}
