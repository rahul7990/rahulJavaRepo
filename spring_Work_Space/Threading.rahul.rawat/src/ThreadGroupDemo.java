

public class ThreadGroupDemo implements Runnable{

	public void run()
	{
		System.out.println("Thread Name:"+Thread.currentThread().getName());
	}
	
	
	public static void main(String[] args) {
		
		ThreadGroupDemo runnable = new ThreadGroupDemo();//creating runnable object
		
		ThreadGroup tg = new ThreadGroup("Rahul_Thread_Group!!");//creating group of threads
		
	
		
		Thread t1 = new Thread(tg,runnable ,"one");
		t1.start();
		Thread t2 = new Thread(tg,runnable ,"two");
		t2.start();
		Thread t3 = new Thread(tg,runnable ,"three");
		t3.start();
		
		System.out.println("ThreadGroup Name:-"+tg.getName());
		tg.list();
		System.out.println(tg.activeCount());
		System.out.println(tg.getParent());
	}
}

