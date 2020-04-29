package comparetrees;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		final int MAX = 100000;
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		BinaryTree tree = new BinaryTree();
		Integer[] set = new Integer[MAX];
		for (int i = 0; i < MAX; i++) {
			set[i] = new Integer(i);
		}
		shuffleArray(set);

		for (Integer i : set) {
			treeSet.add(i);
			tree.insert(i);
		}
		
		long setStart, setStop, binaryStart, binaryStop;
		
		Iterator iterator = treeSet.iterator();
		setStart = System.nanoTime();
	    while(iterator.hasNext()) {
	        System.out.println(iterator.next() + " ");
	    }
	    setStop = System.nanoTime();
	    long setTime = (setStop-setStart)/1000000;
	    System.out.println("Treeset printed all in " + setTime + " milliseconds");
	    
	    binaryStart = System.nanoTime();
	    tree.inOrder();
	    binaryStop = System.nanoTime();
	    long binaryTime = (binaryStop-binaryStart)/1000000;
	    System.out.println("Treeset printed all in " + setTime + " milliseconds");
	    System.out.println("BinaryTree printed all in " + binaryTime + " milliseconds");
	    
	}
	
	
	
	static void shuffleArray(Integer[] ar)
	  {
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }

}
