package My_Stack;


public class Stack_ {
	
	private static int defaultCapacity = 10;
	private int size = 0;
	private int n;
	private int top = -1;
	private Object []arr;
	
	public Stack_()
	{   n = defaultCapacity;
		this.arr = new Object[n];
	}
	
	public int size()
	{
		size = top + 1;
		return size;
		
	}
	
	public Stack_(int capacity)  
	{   n = capacity;
		this.arr = new Object[n];
	}

	public void push(Object element)
	{
		if(top == n)
		{
			System.out.println("Stack is Full:");
			return;
		}
		  arr[++top] = element;
	}
	
	
	public Object pop()
	{
		if(top == -1)
		{
			System.out.println("Stack is Empty:");
			return null; 
		}
		
		Object element;
		element = arr[top];
		arr[top--] = null;
		return element;
		
	}
	
	public void StackTraversal()
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+" element "+arr[i]);
		}
	}
}
