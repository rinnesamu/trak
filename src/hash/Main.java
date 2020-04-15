package hash;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Hash h = new Hash();
		Random r = new Random();
		final int MAX = 100000;
		final int MIN = 1;
		final int DEF = 2505432;
		
		for (int i = 0; i < 100; i++) {
			int key = r.nextInt(MAX - MIN + 1) + MIN;
			h.addKey(key);
		}
		h.addKey(DEF);
		h.printAll();
		System.out.println();
		System.out.println(h.findKey(DEF));
		System.out.println(h.findKey(1111111111));

	}

}
