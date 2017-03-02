package Collection.by.rahul;

import java.util.TreeSet;

public class Manger {

	public static void main(String[] args) {
		TreeSet t = new TreeSet();
		t.add(90);
		t.add(100);
		t.add(10);
		t.add(11);
		t.add(13);
		t.add(15);
		t.add(50);
		t.add(70);
		t.add(60);
		t.add(57);

		System.out.println(t);
		//System.out.println(t.floor(15));
		//System.out.println(t.ceiling(60));
		System.out.println(t.headSet(50));
		System.out.println(t.floor(13));
		System.out.println(t.ceiling(57));
		System.out.println(t.tailSet(13));
	}

}
