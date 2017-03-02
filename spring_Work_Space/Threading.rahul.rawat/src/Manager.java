import java.util.HashMap;
class X extends Thread
{
	HashMap map;
	X(HashMap map)
	{
		this.map = map;
	}
	public void run()
	{
		
		for(int i =0;i<=2;i++)
		{	System.out.println("Putting object with key="+i);
			map.put(i, i+10);
	     }
		}
}

class Y extends Thread
{
	HashMap map;
	Y(HashMap map)
	{
		this.map = map;
	}
	
	public void run()
	{
		for(int i =0;i<=2;i++)
			System.out.println("Key="+i+", Value="+map.get(i));
	}
}


public class Manager {
public static void main(String[] args) throws InterruptedException {
	HashMap map = new HashMap();
	X t1 = new X(map);
	Y t2 = new Y(map);
	t1.start();
	t1.join();
	t2.start();
	t2.join();
	for(int i =0;i<=2;i++)
		System.out.println("Main!!");
	
	
}
}
