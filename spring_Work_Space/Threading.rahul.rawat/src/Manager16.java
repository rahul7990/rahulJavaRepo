class M extends Thread
{
	M()
	{
		start();
	}
  	
	public void run()
	{
		for(int i =0;i<=10;i++)
		{
			System.out.println("From Thread M!!!");
		}
	}
}
public class Manager16 {
public static void main(String[] args) throws InterruptedException {
	M m1 = new M();
	m1.join();
	System.out.println("Main Done :) ");
}
}
