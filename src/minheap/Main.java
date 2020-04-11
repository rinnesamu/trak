package minheap;

public class Main {

	public static void main(String[] args) {
		MinHeap heap = new MinHeap(100);
		heap.insertValue("m");
		heap.print();
		heap.insertValue("s");
		heap.print();
		heap.insertValue("d");
		heap.print();
		heap.insertValue("t");
		heap.print();
		heap.insertValue("c");
		heap.print();
		heap.insertValue("x");
		heap.print();
		heap.deleteMin();
		heap.print();

	}

}
