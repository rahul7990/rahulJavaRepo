class shared{
	
	public void test1()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public void test2()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public synchronized void test3()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public synchronized void test4()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public synchronized static void test5()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public synchronized static void test6()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void test7()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void test9()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}

class ThreadA extends Thread
{
	shared s1;
	
	public ThreadA(shared s)
	{
		 this.s1=s;
	}
	public void run(){
		s1.test5();
	}
}

class ThreadB extends Thread
{
	shared s1;
	
	public ThreadB(shared s)
	{
		this.s1=s;
	}
	public void run(){
		s1.test5();
	}
}

public class CombnationOfThreads {
public static void main(String[] args)  {
	shared s1 = new shared();
	shared s2 = new shared();
	
	ThreadA t1 = new ThreadA(s1);
	ThreadB t2 = new ThreadB(s2);
	
	t1.start();
	
	t2.start();
	
}
}
