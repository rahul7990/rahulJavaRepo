

public class LinkedList {
	public static void main(String[] args) {

		MyLinkList list = new MyLinkList();
		list.add(new ListNode(7));
		list.add(new ListNode(10));
		list.add(new ListNode(15));
		list.ListTravarsal();
		System.out.println("-------------------------");
		list.addAtPosition(new ListNode(50), 2);
	//  list.deleteAtBegining();
		list.ListTravarsal();
		list.deleteAtPosition(3);
		list.ListTravarsal();
        list.countNode();
		}

	
}
