package Collection.set;

import java.util.HashSet;
import java.util.Set;

public class Cutomized_set {
	int i;
	public Cutomized_set(int i)
	{
		this.i=i;
	}
	
	public boolean equals(Object obj)
	{
		return false;
	}
	
	public String toString()
	{
		return "i="+i;
	}

	public static void main(String[] args) {
		
		Set hs = new HashSet();
		hs.add(new Cutomized_set(90));
		hs.add(new Cutomized_set(90));
		hs.add(new Cutomized_set(90));
		hs.add(new Cutomized_set(90));
		
		System.out.println(hs);
	
	}
}
