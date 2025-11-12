/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        ListNode forward = null;
        while(temp != null){
            forward = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forward;
        }
        return prev;
    }

    ListNode remove(ListNode head, int n){
        int cnt = 1;
        ListNode temp = head;
        ListNode prev = null;  

        while(cnt < n){
            prev = temp;
            temp = temp.next;
            cnt++;
        }

        // If we are removing the first node
        if (prev == null) return head.next;

        // If we are removing last node
        if (temp.next == null) prev.next = null;
        else prev.next = temp.next;

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode myHead = reverse(head);
        myHead = remove(myHead, n);
        return reverse(myHead);
    }
}
public class LeetCode19 {
    public static void main(String[] args) {
        // Build sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        System.out.print("Original list: ");
        printList(head);

        Solution solution = new Solution();
        int n = 2; // remove 2nd node from end (expected result: 1->2->3->5)
        ListNode result = solution.removeNthFromEnd(head, n);

        System.out.print("After removing " + n + "th from end: ");
        printList(result);
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
