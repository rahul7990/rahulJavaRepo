
public class Manager18 {

	static class N extends Thread
	{
		public void run()
		{
			for(int i =0;i<=10;i++)
			System.out.println("From Static Inner class Thread");
		}
		
	}
	
	public static void main(String[] args) {
		
		N n1 = new N();
		n1.start();
		for(int i =0;i<=10;i++)
			System.out.println("Main!!");
	}

}
