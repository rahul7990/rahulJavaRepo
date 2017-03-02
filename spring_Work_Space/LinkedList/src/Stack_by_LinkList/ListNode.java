package Stack_by_LinkList;

public class ListNode {

	private int data;
	private int top;
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	private ListNode next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "data=" + data;
	}
	
	
}
