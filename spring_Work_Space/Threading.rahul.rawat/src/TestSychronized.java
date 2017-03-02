class Table
{
	
   	public synchronized void printtable(int n)
   	{
   		for(int i =1;i<=20;i++)
   		{
   			System.out.println(n*i);
   		}
   	}
}

class Thread11 extends Thread
{
   Table t;	
   public Thread11(Table t)
   {
	   this.t = t;
   }
   
   public void run()
   {
	   t.printtable(1);
   }
}

class Thread2 extends Thread
{
   Table t;	
   public Thread2(Table t)
   {
	   this.t = t;
   }
   
   public void run()
   {
	   t.printtable(10);
   }
}

class Thread3 extends Thread
{
   Table t;	
   public Thread3(Table t)
   {
	   this.t = t;
   }
   
   public void run()
   {
	   t.printtable(100);
   }
}

class Thread4 extends Thread
{
   Table t;	
   public Thread4(Table t)
   {
	   this.t = t;
   }
   
   public void run()
   {
	   t.printtable(1000);
   }
}
public class TestSychronized {
	
	public static void main(String[] args) {
		
	
	Table T = new Table();
	Table T1 = new Table();
	Thread11 t11 = new Thread11(T);
	Thread2 t2 = new Thread2(T);
	Thread3 t3 = new Thread3(T);
	Thread4 t4 = new Thread4(T);
	
	t11.start();
	t2.start();
	t3.start();
	t4.start();
	}
}
