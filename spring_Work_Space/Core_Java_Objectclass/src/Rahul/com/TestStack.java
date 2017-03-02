package Rahul.com;
interface StackMethods
{
  public int size();
  public void push(Object element);
  public Object pop();
  public Object top();
  public void stackTraversal();

}

class Stack implements StackMethods
{
private static final int CAPACITY=100;
private Object S[];
private int N;
public int TOP = -1;

Stack()
{
this(CAPACITY);
}


Stack(int capacity)
{
	N=capacity;
	S = new Object[N];
}

public void stackTraversal()
{
	for (int i = 0; i < S.length; i++) {
		System.out.println(i+" element "+S[i]);
	}
}

@Override
public int size() {
	
	return TOP+1;
}


@Override
public void push(Object element) {
	if(TOP==N)
	{
		System.out.println("Stack is Full!!!!");
	}
	
	S[++TOP]=element;
	
}


@Override
public Object pop() {
	Object element;
	if(TOP==-1)
	{
		System.out.println("Stack is empty!!!");	
	}
	element = S[TOP];
	S[TOP--] = null; //TOP--=NULL means first decrease the TOP and then assign null(for Garbage collection)
	return element;
}


@Override
public Object top() {
	// TODO Auto-generated method stub
	return TOP;
}
  
}

public class TestStack {

	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push(1);
		s1.push(45);
		s1.push(1);
		s1.push(45);
		s1.stackTraversal();
		System.out.println("Value of TOP:-"+s1.TOP);
		System.out.println("Size of Stack:-"+s1.size());
		s1.pop();
		s1.pop();
		System.out.println("Value of TOP:-"+s1.TOP);
		System.out.println("Size of Stack:-"+s1.size());
		
		
	}
}
