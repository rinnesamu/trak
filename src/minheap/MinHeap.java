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
			while (i / 2 != 0 && heap[i].getData().compareTo(heap[i / 2].getData()) < 0) {
				swap(i);
				i = i / 2;
			}
			size++;
		}

	}

	private void swap(int i) {
		Node temp = heap[i];
		heap[i] = heap[i/2];
		heap[i/2] = temp;
	}

	public Node deleteMin() {
		boolean ready = false;
		Node node = null;
		if (this.size == 0) {
			return null;
		}
		node = heap[FRONT];
		heap[FRONT] = heap[this.size];
		heap[this.size] = null;
		this.size--;
		int i = FRONT;
		while (ready == false) {
			if (heap[i*2] != null && heap[i*2+1] != null) {
				if (heap[i].getData().compareTo(heap[i*2].getData()) <= 0
						&& heap[i].getData().compareTo(heap[i*2+1].getData()) <= 0) {
					ready = true;
				} else if (heap[i*2].getData().compareTo(heap[i*2+1].getData()) <= 0) {
					i = 2 * i;
					swap(i);
				} else {
					i = 2 * i + 1;
					swap(i);
				}

			} else if (heap[i*2] != null) {
				if (heap[i].getData().compareTo(heap[i*2].getData()) < 0) {
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
		System.out.println("Jokaisen solmun lapset:");
		for (int i = 1; i < size; i++) {
			if (heap[i*2+1] != null) {
				System.out.println("Solmu: " + heap[i].getData() + " Vasen lapsi: " + heap[i*2].getData() + " Oikea lapsi: " + heap[i*2+1].getData());
			}else if (heap[i*2] != null) {
				System.out.println("Solmu: " + heap[i].getData() + " Vasen lapsi: " + heap[i*2].getData());
			}
		}
	}

}
