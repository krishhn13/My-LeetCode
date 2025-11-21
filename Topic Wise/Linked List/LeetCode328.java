class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second;
        while( first.next!=null && second.next!=null ) {
            first.next = second.next;
            second.next = first.next.next;
            first = first.next;
            second = second.next;
        }
        first.next = third;
        return head;
    }
}
public class LeetCode328 {
        public static void main(String[] args) {
                // Example: build list 1->2->3->4->5
                ListNode n1 = new ListNode(1);
                ListNode n2 = new ListNode(2);
                ListNode n3 = new ListNode(3);
                ListNode n4 = new ListNode(4);
                ListNode n5 = new ListNode(5);
                n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

                Solution solution = new Solution();
                ListNode result = solution.oddEvenList(n1);

                // Print resulting list
                for (ListNode cur = result; cur != null; cur = cur.next) {
                        System.out.print(cur.val);
                        if (cur.next != null) System.out.print(" -> ");
                }
                System.out.println();
        }
}
