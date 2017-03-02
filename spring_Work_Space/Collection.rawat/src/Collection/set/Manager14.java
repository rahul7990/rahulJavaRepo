package Collection.set;

import java.util.HashSet;
import java.util.Set;

class E
{
   double i;
   public E(double i)
   {
	   this.i =i;
   }
   
   public int hashCode()
   {
	   return Double.toString(i).hashCode();
   }
   
   public boolean equals(Object obj)
   {
	   E e1 = (E)obj;
	   return e1.i == i;
	   
	   //return ((E)obj).i == i;
   }
   
   public String toString()
   {
	   return "i="+i;
   }

}
public class Manager14 {

	public static void main(String[] args) {
		
		Set hs1 = new HashSet();
		hs1.add(90);
		hs1.add(90);
		
		System.out.println("Size of set:-----"+hs1.size());
		System.out.println(hs1);
		
		Set hs2 = new HashSet();
		hs2.add("Rahul");
		hs2.add("Rahul");
		
		System.out.println("Size of set:-----"+hs2.size());
		System.out.println(hs2);
		
		Set hs3 = new HashSet();
		hs3.add(new E(9.9));
		hs3.add(new E(9.9));
		
		System.out.println("Size of set:-----"+hs3.size());
		System.out.println(hs3);
		
		Set hs4 = new HashSet();
		hs4.add(new StringBuffer("Rahul"));
		hs4.add(new StringBuffer("Rahul"));
		
		System.out.println("Size of set:-----"+hs4.size());
		System.out.println(hs4);
		
	}
}
