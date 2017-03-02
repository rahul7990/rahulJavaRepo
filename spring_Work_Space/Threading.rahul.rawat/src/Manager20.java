
public class Manager20 {

	public static void main(String[] args) {
		
	
	class K extends Thread
	{
		K()
		{
			start();
		}
		public void run()
		{
			for(int i =0;i<=10;i++)
			System.out.println("from K inner Thread ");
		}
	}
	
	K k1 = new K();
	for(int i =0;i<=10;i++)
		System.out.println("Main!!!");
	
	}
}
