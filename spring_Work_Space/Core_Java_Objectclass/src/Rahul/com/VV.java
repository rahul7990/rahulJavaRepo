package Rahul.com;

class J
{
int i;


}

public class VV implements Cloneable{
   
	int k;
	J j1;
	
	public Object clone() throws CloneNotSupportedException
	{
		VV V1 = (VV)super.clone();
		
		V1.j1=new J();
		V1.j1.i= this.j1.i;
		return V1;
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		J j = new J();
		j.i=100;
		
		VV obj = new VV();
		obj.k=100;
		obj.j1= new J();
		obj.j1.i=10;
		
		
		VV obj2 = (VV)obj.clone();
		
		System.out.println(obj2.k);
		System.out.println(obj2.j1.i);
		
		obj2.k=1000;
		obj2.j1.i=22222;
		
		System.out.println(obj.k);
		System.out.println(obj.j1.i);
		
			
	}
}
