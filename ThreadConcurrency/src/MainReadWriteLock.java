import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MainReadWriteLock {

	public static void main(String[] args) {
		ReadWriteLock readwriteloack = new ReentrantReadWriteLock();
		MyReadWriteRunable myReadWriteRunable = new MyReadWriteRunable(readwriteloack);
		
		Thread thread1 = new Thread(myReadWriteRunable);
		Thread thread2 = new Thread(myReadWriteRunable);
		Thread thread3 = new Thread(myReadWriteRunable);
		Thread thread4 = new Thread(myReadWriteRunable);
		Thread thread5 = new Thread(myReadWriteRunable);
		Thread thread6 = new Thread(myReadWriteRunable);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
}

class MyReadWriteRunable implements Runnable{

	ReadWriteLock readwriteloack;
	
	public MyReadWriteRunable(ReadWriteLock readwriteloack) {
		this.readwriteloack=readwriteloack;
	}
	
	
	@Override
	public void run() {
		
		//readwriteloack.readLock().lock();
		readwriteloack.writeLock().lock();
		System.out.println("Thread :"+ Thread.currentThread().getName() +"has accuired read loack");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//readwriteloack.readLock().unlock();
		readwriteloack.writeLock().unlock();
		
		System.out.println("Thread :"+Thread.currentThread().getName() +"has released the read lock");
	}
	
	
}