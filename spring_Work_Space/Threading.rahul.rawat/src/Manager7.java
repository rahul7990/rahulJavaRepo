class MyRunnable implements Runnable
{
  public void run()
  {
	  for(int i=1;i<=10;i++)
	  {
		  System.out.println("From MyRunnable :"+i);
	  }
  }
}
public class Manager7 {
public static void main(String[] args) {
	MyRunnable m = new MyRunnable();
	Thread t1 = new Thread(m);
	t1.start();
	for(int i=0;i<=10;i++)
		System.out.println("main!!!");
}
}
