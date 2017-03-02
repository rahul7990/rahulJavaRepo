 class Table_Shared{
	
	 public synchronized void printtable(int n)
	 {
		 for(int i=0;i<10;i++)
		 {
			 System.out.println(Thread.currentThread().getName()+" "+n*i);
		 }
	 }
	
}
 
 class Thread1 extends Thread
 {
    Table t;	
    public Thread1(Table t)
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
 	   t.printtable(1);
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
 	   t.printtable(1);
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
 	   t.printtable(1);
    }
 }




public class TestSnchronizedClassLevel {

	public static void main(String[] args) {
		
		
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		Thread4 t4 = new Thread4();
		

	}

}
