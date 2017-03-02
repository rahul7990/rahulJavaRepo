
public class Manager25 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			public void run()
			{
			for(int i =0;i<=10;i++)
			System.out.println("From Child Thread!!");
			}
		       });
		t1.start();
		System.out.println("Main!! DOne");
		

	}

}
