import java.util.*;
class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (ListNode node : lists) {
                        while (node != null) {
                                pq.add(node.val);
                                node = node.next;
                        }
                }
                ListNode dummy = new ListNode(-1);
                ListNode curr = dummy;
                while (!pq.isEmpty()) {
                        curr.next = new ListNode(pq.poll());
                        curr = curr.next;
                }
                return dummy.next;
        }
}