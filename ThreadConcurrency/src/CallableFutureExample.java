import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumIntegerCallable implements Callable<Integer> {
	 
    Integer n;
 
    SumIntegerCallable(Integer n) {
           this.n = n;
    }
 
    @Override
    public Integer call() throws Exception {
          /* Integer sum = 0;
           for (int i = 0; i <= n; i++) {
                  sum += i;
           }
           return sum;*/
    	return 10;
    }
 
}


public class CallableFutureExample {
	  private static final int NTHREDS = 10;
	 
	  public static void main(String[] args) throws InterruptedException, ExecutionException {
	 
	    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	    Future<Integer> futureInteger=executor.submit(new SumIntegerCallable(4));
	   
	   
	    System.out.println("SumIntegerCallable has returned > "+futureInteger.get());
	   
	        
	    executor.shutdown();
	  }
	}