package leetCode30Day;

public class MiddleNode8 {

	public static void main(String[] args) {
		int [] arr = {1,2,3,9,4,5};
		
		ListNode head = new ListNode(arr[0]);
		ListNode tmepNode = head;
		for(int i = 1 ; i < arr.length ; i++) {
			tmepNode.next = new ListNode(arr[i]);
			tmepNode= tmepNode.next;
		}
		
		ListNode ansNode = middleNode(head);
		System.out.println(ansNode.val);

	}
	
	public static ListNode middleNode(ListNode head) {
		ListNode tempNode = head;
		int length = 0;
		int middleNodeIndex = 0;
		// compute the length of given List 
		while(tempNode != null ) {
			length++;
			tempNode = tempNode.next;
		}
			
		middleNodeIndex = length/2 + 1;
		tempNode= head;
		for(int i = 1 ; i != middleNodeIndex ; i++) {
			tempNode = tempNode.next;
		}

		return tempNode;
	}
}

 class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

