package queue;

public class Queue {
	private ListItem head = null;
	private ListItem tail = null;
	private int size = 0;
	
	public void push(String aData) {
		ListItem l = new ListItem();
		l.setData(aData);
		if(tail != null) {
			tail.setNext(l);
		}
		if (head == null) {
			head = l;
		}
		tail = l;
		this.size++;	
	}

	public ListItem pop() {
		ListItem returnListItem = null;
		if (head != null) {
			returnListItem = head;
			head = head.getNext();
			this.size--;
		}
		return returnListItem;
	}
	
	public void printItems() {
		ListItem l = head;
		while (l != null) {
			System.out.println(l.getData());
			l = l.getNext();
		}
		
	}
	
	public int getSize() {
		return this.size;
	}

}
