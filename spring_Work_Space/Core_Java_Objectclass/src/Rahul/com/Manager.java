package Rahul.com;


class K
{
int i,j;

K(int i,int j)
{
  	this.i = i;
  	this.j = j;
}

public int hashCode()
{
   String s1 = Integer.toString(i);
   String s2 = Integer.toString(j);
   int hash = s1.hashCode();
   hash += s2.hashCode();
   return hash;



}

public boolean equals(Object obj)
{

  boolean flag = (this.i==((K)obj).i)&&(this.j==((K)obj).j);
	
	return flag;
}

}



class Manager
{
public static void main(String[] args) {
	
	K obj1 = new K(10,20);
    K obj2 = new K(10,20);
	
	System.out.println(obj1.hashCode());
	System.out.println(obj2.hashCode());
	System.out.println(obj1.equals(obj2));
	System.out.println(obj1==obj2);
	
	
}	
}
