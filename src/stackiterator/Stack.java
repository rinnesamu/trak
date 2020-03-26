/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackiterator;

/**
 *
 * @author kamaj
 */
public class Stack {

	ListItem top; // suurimmalla indeksillä varustettu item
	private final int MAX = 10;
	private int size;
	private ListItem[] items;

	public Stack() {
		top = null;
		size = 0;
		items = new ListItem[MAX];
	}

	// palautetaan pino-iteraattori
	public StackIterator iterator() {
		return new StackIterator(this);
	}

	// muodostetaan uusi alkio ja viedään se huipulle
	public void push(String aData) {
		if (this.size == MAX) {
			System.out.println("Pino täynnä!");
		} else {
			ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
			newItem.setData(aData);
			newItem.setIndex(this.size);
			items[this.size] = newItem;
			top = newItem;
			this.size++;
		}
	}

	// poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
	public ListItem pop() {
		ListItem takeAway;
		if (top == null) {
			takeAway = null; // pino on tyhjä
		} else {
			this.size--;
			takeAway = items[this.size];
			items[this.size] = null;
			if (this.size == 0) {
				top = null;
			} else {
				top = items[this.size-1];
			}
		}
	
		return takeAway;
	}

	// palautetaan pinottujen alkioiden lukumäärä
	public int getSize() {
		return size;
	}
	
	public ListItem getNext(int index) {
		if (index == 0) {
			return null;
		} else {
			return items[index-1];
		}
	}

	// listataan sisältö
	public void printItems() {
		ListItem lPointer;
		for (int i = this.size-1; i >= 0; i--) {
			lPointer = this.items[i];
			System.out.print(lPointer.getData() + ", ");
		}
	}
}
