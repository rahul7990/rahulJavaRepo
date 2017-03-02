package code.java.string;

class Singlton
{
 private static volatile Singlton instance1 = null;
 
 private Singlton()
 {
	 
 }
 
 public static Singlton getSinglton()
 {
	 if(instance1==null)
	 {
		 synchronized (Singlton.class) {
			
			 instance1 = new Singlton();
		}
	 }
	 
	 return instance1;
 }
 
 
 
}


public class Test {
	  
  
	private static int count=0;  
Test() throws Exception  
	{    
	if(count==0)   
	{  
	System.out.println("Object Created.");  
	count++;  
	}  
else throw new Exception("Singleton Class cannot have more than one Object.");  
	}  
public static void main(String args[])  
	{  
try{  
	Test s1=new Test();  
	Test s2=new Test();  
	Test s3=new Test();  
	}catch(Exception e)  
	{  
	System.out.println("Exception: "+e.getMessage());      
	}  
	}  
}
