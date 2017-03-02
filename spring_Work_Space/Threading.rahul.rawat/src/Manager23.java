
public class Manager23 {
public static void main(String[] args) throws InterruptedException {
	
	Runnable r1 = new Runnable(){
		public void run()
		{
			for(int i =0;i<=10;i++)
				System.out.println("From Child Thread!!");
		}
	};
	
	Thread t1 = new Thread(r1);
	t1.start();
	t1.join();
	System.out.println("From Main Finish!!");
}
}
