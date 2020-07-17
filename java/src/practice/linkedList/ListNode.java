package practice.linkedList;

 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
    
	public static void printList(ListNode head) {
		System.out.println("Priting the list");
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();
	}
 }
