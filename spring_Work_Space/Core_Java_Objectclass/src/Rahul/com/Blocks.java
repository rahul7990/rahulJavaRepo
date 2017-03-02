package Rahul.com;

class instance
{
	
	static 
	{
		System.out.println("static block!!");
	}
	{
		System.out.println("Instance block!!");
	}	


}

public class Blocks {

	public static void main(String[] args) {
		instance i,i1;
		new instance();
		i = new instance();
		i1 = new instance();
}
}
