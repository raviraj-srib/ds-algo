package practice.linkedList;

public class RemoveNthFromLast {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode aheadPtr = head;
		ListNode curPtr = head;

		while (n > 0) {
			aheadPtr = aheadPtr.next;
			n--;
		}
		System.out.println("AHEAD : " + aheadPtr
				);

		while (aheadPtr != null) {
			curPtr = curPtr.next;
			aheadPtr = aheadPtr.next;
		}
		System.out.println("CUR : " + curPtr);

		if (curPtr == head) {
			head = head.next;
		} else {
			curPtr.next = curPtr.next.next;
		}
		System.out.println("Head : " + head);

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		
		  node2.next = node3; node3.next = node4; node4.next = node5;
		 

		ListNode.printList(removeNthFromEnd(head, 2));
	}
}
