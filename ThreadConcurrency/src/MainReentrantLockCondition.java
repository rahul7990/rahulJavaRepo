import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLockCondition {
	public static void main(String[] args) {

		List<Integer> SharedQueue = new LinkedList<Integer>();
		
		Lock lock = new ReentrantLock();
		
		Condition producerCondition = lock.newCondition();
		Condition consumerCondition = lock.newCondition();
		
		Producer  producer = new Producer(SharedQueue, lock, producerCondition, consumerCondition);
		Consumer consumer = new Consumer(SharedQueue, lock, producerCondition, consumerCondition);
		
		Thread Thread1 = new Thread(producer);
		Thread Thread2 = new Thread(consumer);
		
		Thread1.start();
		Thread2.start();
	}
}

class Producer implements Runnable {

	private List<Integer> SharedQueue;
	private int MAXSize = 2;

	Lock lock;
	Condition producerCondition;
	Condition consumerCondition;

	public Producer(List<Integer> SharedQueue, Lock lock,
			Condition producerCondition, Condition consumerCondition) {
		this.SharedQueue = SharedQueue;
		this.lock = lock;
		this.consumerCondition = consumerCondition;
		this.producerCondition = producerCondition;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	private void produce(int i) throws InterruptedException {
		lock.lock();
		if (SharedQueue.size() == MAXSize)
			producerCondition.await();

		SharedQueue.add(i);
		System.out.println("Produced : " + i);
		consumerCondition.signal();
		lock.unlock();

	}

}

class Consumer implements Runnable {
	private List<Integer> SharedQueue;
	Lock lock;
	Condition producerCondition;
	Condition consumerCondition;

	public Consumer(List<Integer> SharedQueue, Lock lock,
			Condition producerCondition, Condition consumerCondition) {
        this.SharedQueue=SharedQueue;
		this.lock=lock;
		this.consumerCondition=consumerCondition;
		this.producerCondition=producerCondition;
		
	}

	@Override
	public void run() {
		for(int i =1 ;i<=10;i++){
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException{
		lock.lock();
		if(SharedQueue.size()==0)
			consumerCondition.await();
		
		System.out.println("Consumed : "+SharedQueue.remove(0));
		producerCondition.signal();
		lock.unlock();
		
	}
}