class Box
{
   private int content;
   private boolean available=false;
   
   public synchronized int get()
   {
	   while(available == false)
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   available = false;
	   notifyAll();
	   return content;
   }
   
   
   public synchronized void put(int value)
   {
	   while(available == true)
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   
	   content = value;
	   available=true;
	   notifyAll();
   }
}

class Producer extends Thread
{
  	private Box b;
  	Producer(Box b)
  	{
  		this.b=b;
  	}
  	
  	public void run()
  	{
  		for(int i =0;i<10;i++)
  		{	b.put(i);
  		System.out.println("Produced:"+i);
  //		try {
  		//	sleep((int)(Math.random() * 100));
  		//	} catch (InterruptedException e) { }
  		}
  		
  	}
}

class Consumer extends Thread
{
   private Box b;
   Consumer(Box b)
   {
	   this.b=b;
   }
   
   public void run()
   {
	   int value=0;
		for(int i =0;i<10;i++)
		{	value = b.get();
		System.out.println("Consumed:"+value);
		}
   }
}
public class RahulProducerConsumer {

	public static void main(String[] args) {
		
		Box box = new Box();
		Producer t1 = new Producer(box);
		Consumer t2 = new Consumer(box);
		t1.start();
		t2.start();
	
	}

}
