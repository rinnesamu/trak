package queue;

public class ListItem {

	private String data;
	private ListItem next;
	
	public ListItem() {
		this.next = null;
	}
	public String getData() {
		return data;
	}
	public void setData(String date) {
		this.data = date;
	}
	public ListItem getNext() {
		return next;
	}
	public void setNext(ListItem next) {
		this.next = next;
	}
	
	
}
