package minheap;

/**
 * 
 * @author Samu Rinne
 *
 */

public class MinHeap {
	private Node[] heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.heap = new Node[this.maxSize];
	}

	public void insertValue(String data) {
		Node node = new Node(data);
		if (heap[FRONT] == null) {
			heap[FRONT] = node;
			this.size++;
		} else {
			int i = size + 1;
			heap[i] = node;
			heap[i].setParent(heap[i / 2]);
			if (i % 2 == 0) {
				heap[i / 2].setLeft(heap[i]);
			} else {
				heap[i / 2].setRight(heap[i]);
			}
			while (i / 2 != 0 && heap[i].getData().compareTo(heap[i / 2].getData()) < 0) {
				swap(i);
				i = i / 2;

			}
			size++;
		}

	}

	private void swap(int i) {

		Node newParent;
		System.out.println("Alkaa");
		System.out.println(heap[i / 2].getData());
		System.out.println(heap[i]);
		System.out.println(heap[i].getLeft());
		System.out.println(heap[i].getRight());
		Node newChild = new Node(heap[i / 2].getData(), heap[i], heap[i].getLeft(), heap[i].getRight());
		if (i % 2 == 0) {
			newParent = new Node(heap[i].getData(), heap[i / 2].getParent(), heap[i / 2], heap[i / 2].getRight());
		} else {
			newParent = new Node(heap[i].getData(), heap[i / 2].getParent(), heap[i / 2].getLeft(), heap[i / 2]);
		}
		heap[i] = newChild;
		heap[i / 2] = newParent;
		if (newParent.getParent() != null) {
			int a = i/2;
			if (i/2 % 2 == 0) {
				heap[a/2].setLeft(newParent);
			}else if (heap[a/2].getRight().getData().compareTo(newChild.getData()) == 0) {
				heap[a/2].setRight(newParent);
			}
		}
		System.out.println("Swapped " + heap[i].getData() + " and " + heap[i/2].getData());
	
	}

	public Node deleteMin() {
		boolean ready = false;
		Node node = null;
		if (this.size == 0) {
			return null;
		}
		node = heap[FRONT];
		System.out.print(heap[this.size/2].getLeft());
		if (heap[this.size/2].getLeft().equals(heap[this.size])) {
			heap[this.size/2].setLeft(null);
		} else {
			heap[this.size/2].setRight(null);
		}
		heap[FRONT] = heap[this.size];
		heap[this.size] = null;
		this.size--;
		heap[FRONT].setParent(node.getParent());
		heap[FRONT].setLeft(node.getLeft());
		heap[FRONT].setRight(node.getRight());
		int i = FRONT;
		while (ready == false) {
			if (heap[i].getLeft() != null && heap[i].getRight() != null) {
				if (heap[i].getData().compareTo(heap[i].getLeft().getData()) <= 0
						&& heap[i].getData().compareTo(heap[i].getRight().getData()) <= 0) {
					ready = true;
				} else if (heap[i].getLeft().getData().compareTo(heap[i].getRight().getData()) <= 0) {
					i = 2 * i;
					swap(i);
				} else {
					i = 2 * i + 1;
					swap(i);
				}

			} else if (heap[i].getLeft() != null) {
				if (heap[i].getData().compareTo(heap[i].getLeft().getData()) < 0) {
					ready = true;
				} else {
					i = 2 * i;
					swap(i);
				}
			} else {
				ready = true;
			}
		}
		return node;

	}

	public void print() {
		System.out.println("Kasa ylhäältä alas, vasemmalta oikealle");
		for (int i = FRONT; i <= this.size; i++) {
			System.out.println(heap[i].getData());
		}
		System.out.println();
		System.out.println("Jokaisen solmun vasen ja oikea lapsi:");
		for (int i = FRONT; i <= this.size; i++) {
			if (heap[i].getLeft() != null && heap[i].getRight() != null) {
				System.out.println("Solmu: " + heap[i].getData() + ", Vasen lapsi: " + heap[i].getLeft().getData()
						+ ", Oikea lapsi: " + heap[i].getRight().getData());
			} else if (heap[i].getLeft() != null) {
				System.out.println("Solmu: " + heap[i].getData() + ", Vasen lapsi: " + heap[i].getLeft().getData()
						+ ", Oikea lapsi: " + heap[i].getRight());
			} else if (heap[i].getLeft() != null) {
				System.out.println("Solmu: " + heap[i].getData() + ", Vasen lapsi: " + heap[i].getLeft()
						+ ", Oikea lapsi: " + heap[i].getRight().getData());
			} else {
				System.out.println("Solmu: " + heap[i].getData() + ", Vasen lapsi: " + heap[i].getLeft()
						+ ", Oikea lapsi: " + heap[i].getRight());
			}
		}
		System.out.println();
	}

}
