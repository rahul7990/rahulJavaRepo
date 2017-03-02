package My_Stack;

public class MyStack {

	public static void main(String[] args) {
		
		Stack_ st = new Stack_(6);
		
		st.push(7);
		st.push(8);
		st.push(12);
		st.push(24);
		st.push(34);
		st.push(50);
		System.out.println("---------traversal------------");
		st.StackTraversal();
		System.out.println("---------Now POP ------------");
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println("---------traversal------------");
		st.StackTraversal();
		
		
		

	}

}
