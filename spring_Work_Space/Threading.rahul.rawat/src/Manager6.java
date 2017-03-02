class Thread1 extends Thread
{
 
	public void run()
	{
		for(int i = 0;i<=10;i++)
		System.out.println("From Thread1 counter is:="+i);
	}

}
public class Manager6 {

	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		t1.start();
		for(int i = 0;i<=10;i++)
			{System.out.println("Excecuting main:!!");
             t1.join();
			}
	}

}
