import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{

	int tasknumber;
	
	Task(int tasknumber){
	this.tasknumber=tasknumber;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+": "+tasknumber);
		System.out.println("DB Connection Open::");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}

public class ExecutorServiceExample {

	static int numberOfThreads = 2;
	static int numberOfTasks = 10;
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
		//thread pool created with 2 threads here.....
		
		for(int i=0;i<numberOfTasks;i++){
			 Task task = new Task(i);
			executor.execute(task); 
			// passing runnable(task) to execute method here method executing command(task) for new threads which are in pool
			
			/*Thread thread = new Thread(new Task(i));
			executor.execute(thread);
			*/	
		}	
			executor.shutdown();
			System.out.println("Executor has been shutdown:");
	}
}

// In our case command or Task is : run() code where we are opening DB connection.


