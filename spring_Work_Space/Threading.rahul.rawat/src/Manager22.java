
public class Manager22 {

	public static void main(String[] args) throws InterruptedException {
	  
		Thread t1 = new Thread(){
			
			public void run()
			{
				for(int i =0;i<=10;i++)
					System.out.println("From Child thread!!");
			}
		};
		
		t1 .start();
		t1.join();
		for(int i =0;i<=3;i++)
			System.out.println("From Main!!");

	}

}
