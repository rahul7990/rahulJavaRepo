package code.java.string;

public class DoubletonDemo
{
private static DoubletonDemo doubletonDemo1=null;
private static DoubletonDemo doubletonDemo2=null;

private DoubletonDemo()
	{
// private constructor so the object cann't create from outside the class.
 }
public static DoubletonDemo getDoubletonDemo()
	{
	if(doubletonDemo1==null)
	{
	doubletonDemo1=new DoubletonDemo();
	return doubletonDemo1;
	}
	else if(doubletonDemo2==null)
	{
	doubletonDemo2=new DoubletonDemo();
	return doubletonDemo2;
	}
	else
	{ 
	if(Math.random() < 0.5)
	{ return doubletonDemo1;} /* we will get the DoubletonDemo object 
	randomly by some rounding order */
	else
	{return doubletonDemo2;}
	}
	}
	public static void main(String[] args)
	{
	DoubletonDemo d1=getDoubletonDemo();
	DoubletonDemo d2=getDoubletonDemo(); // output: 274415197
	DoubletonDemo d3=getDoubletonDemo(); // 1448825870
	DoubletonDemo d4=getDoubletonDemo(); // 274415197
	DoubletonDemo d5=getDoubletonDemo(); // 1448825870
	System.out.println(d1.hashCode()); // 274415197
	System.out.println(d2.hashCode());
	System.out.println(d3.hashCode());
	System.out.println(d4.hashCode());
	System.out.println(d5.hashCode());
	}
} 