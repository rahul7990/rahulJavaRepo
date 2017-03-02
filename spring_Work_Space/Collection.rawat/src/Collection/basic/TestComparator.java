package Collection.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Emp implements Comparator<Emp>{
	
	private String name;
	private int id;
	
	public Emp(String string, int i) {

		this.id=i;
		this.name=string;
	}


	public Emp() {
	}


	@Override
	public String toString() {
		return "Emp [name=" + name + ", id=" + id + "]";
	}

	
	@Override
	public int compare(Emp o1, Emp o2) {
		
		return o1.name.compareTo(o2.name);
	}
	
}
public class TestComparator {

	public static void main(String[] args) {
		
		Emp e1 = new Emp("Rahul",1);
		Emp e2 = new Emp("Rakesh",57);
		Emp e3 = new Emp("neelam",56);
		Emp e4 = new Emp("vijendra",23);
		Emp e5 = new Emp("shyam",45);
		
		List<Emp> list = new ArrayList();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		Collections.sort(list, new Emp());
		
		System.out.println(list);
		
		
		
	}
}
