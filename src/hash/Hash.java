package hash;

public class Hash {

	private int[] hashTable;
	private final int TABLESIZE = 6143;

	public Hash() {
		this.hashTable = new int[TABLESIZE];
	}

	public void addKey(int key) {
		boolean ready = false;
		int tries = 0;
		int i = key % TABLESIZE;
		int originalI = i;
		while (!ready) {
			tries++;
			if (hashTable[i] == 0) {
				hashTable[i] = key;
				ready = true;
			} else {
				System.out.println(tries + ". try was " + i + ". It was already taken!");
				i = (originalI + tries*tries) % TABLESIZE;
				System.out.println("Tryin " + i + " next!");
				
			}
		}

	}

	public boolean findKey(int key) {
		int tries = 0;
		int i = key % TABLESIZE;
		int originalI = i;
		while (hashTable[i] != 0) {
			tries++;
			if(hashTable[i] == key) {
				return true;
			}
			i = (originalI + tries*tries) % TABLESIZE;
			
		}
		return false;
	}
	
	public void printAll() {
		for (int i = 0; i < TABLESIZE-1; i++) {
			System.out.print(hashTable[i] + ", ");
			if (i % 60 == 59) {
				System.out.println();
			}
		}
	}

}
