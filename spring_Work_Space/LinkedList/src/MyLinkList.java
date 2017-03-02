
public class MyLinkList {

	ListNode headNode = null;
	ListNode tailNode = null;
	static int counter = 0;
	
	public void ListTravarsal()
	{   
		ListNode currentNode = headNode;
		while(currentNode!=null)
		{
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	
	}
	
	public void countNode()
	{
		System.out.println("Total no of nodes is:-"+counter);
	}
	
	
	public void add(ListNode nodeToInsert)
	{
		if(headNode==null)
		{ nodeToInsert.setNext(headNode);	
		  headNode = nodeToInsert;
		  tailNode = nodeToInsert;
		}
		else
		{
			tailNode.setNext(nodeToInsert);
			tailNode = nodeToInsert;
		}
			counter++;
	}
	
	public void addAtPosition(ListNode nodeToInsert, int position)
	{
		if(position > counter || position < 1)
		{
			System.out.println("Enter valid position:!!");
			return;
		}
		
		else if(position == 1)
			{
			nodeToInsert.setNext(headNode);
		    headNode = nodeToInsert;
			}
		else
		{
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position-1)
			{
				previousNode = previousNode.getNext();
				count++;
			}
			//currently available node for given position
			ListNode currentNode = previousNode.getNext();   
		    nodeToInsert.setNext(currentNode);
		    previousNode.setNext(nodeToInsert);
		    
		}
		
		counter++;
	}
	
	
	public void deleteAtBegining()
	{
		ListNode temp;
		temp = headNode;
		headNode = headNode.getNext();
		System.out.println("Node "+temp.getData()+" has been deleted from list!!!");
		temp = null;
	}
	
	public void deleteAtPosition(int position)
	{
		ListNode previousNode = headNode;
		int count = 1;
		while(count < position-1)
		{
			previousNode = previousNode.getNext();
			count ++;
		}
		
		ListNode currentNode = previousNode.getNext();
		previousNode.setNext(currentNode.getNext());
		currentNode = null;
		counter--;
	}

}
