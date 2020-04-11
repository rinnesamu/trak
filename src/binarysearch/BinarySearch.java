package binarysearch;

public class BinarySearch {

	private Node[] nodes;
	private int size;

	public BinarySearch() {
		this.nodes = new Node[100];
		this.size = 0;
	}

	public boolean insertNode(String data) {
		Node node = new Node(data);
		// Jos ensimmäinen on null, ei vielä alkioita taulussa.
		if (nodes[0] == null) {
			this.nodes[0] = node;
			this.size++;
			return true;
		}
		// muuten lähdetään etsimään paikkaa rekursiivisesti
		return findInsertionPlace(0, (size - 1), node);
	}

	private boolean findInsertionPlace(int min, int max, Node node) {
		int compare = (min + max) / 2;
		if (max == min) {
			if (node.getData().compareTo(nodes[max].getData()) > 0) {
				for (int i = this.size; i > max; i--) {
					nodes[i] = nodes[i - 1];
				}
				nodes[max + 1] = node;
			} else {
				for (int i = this.size; i > max; i--) {
					nodes[i] = nodes[i - 1];
				}
				nodes[max] = node;
			}
			this.size++;
			return true;
		}
		if (node.getData().compareTo(nodes[compare].getData()) > 0) {
			return findInsertionPlace(compare + 1, max, node);
		} else {
			return findInsertionPlace(min, compare, node);
		}
	}

	public Node findNode(String data) {
		if (this.size == 0) { // jos koko 0, ei voi löytyä
			return null;
		}
		return findNodePlace(0, (size - 1), data);
	}

	private Node findNodePlace(int min, int max, String data) {
		int compare = (min + max) / 2;
		Node node = null;
		if (min == max) {
			if (nodes[min].getData().equals(data)) {
				node = nodes[min];
			}
			return node;
		}
		if (data.compareTo(nodes[compare].getData()) > 0) {
			return findNodePlace(compare + 1, max, data);
		} else if (data.compareTo(nodes[compare].getData()) < 0) {
			return findNodePlace(min, compare, data);
		} else {
			node = nodes[compare];
		}
		return node;
	}

	public void printAll() {
		for (int i = 0; i < this.size; i++) {
			System.out.println(nodes[i].getData());
		}
	}
}
