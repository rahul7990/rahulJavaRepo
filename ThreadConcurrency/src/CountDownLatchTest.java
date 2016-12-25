import java.util.concurrent.CountDownLatch;

class MyRunnable implements Runnable{

	CountDownLatch countDownLatch;
	
	MyRunnable(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
   for(int i=2; i>=0;i--){
	   
	   System.out.println(Thread.currentThread().getName()+" has reduced latch count to "+ i);
	   
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   
	   countDownLatch.countDown();   
   }
		
	}
	
	
}



public class CountDownLatchTest {
	
	public static void main(String[] args) {
	CountDownLatch countDownLatch = new CountDownLatch(3);
	MyRunnable myRunnable = new MyRunnable(countDownLatch);
	Thread thread = new Thread(myRunnable);
	
	thread.start();
	
	try {
		countDownLatch.await();
		System.out.println("Main Thread :"+Thread.currentThread().getName());
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	
}
