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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode t = head;
        while(temp!=null) {
            if(temp.val == 0 && temp.next!=null) {
                t.next = temp;
                t = t.next;
            }
            t.val+=temp.val;
            temp=temp.next;
        }
        t.next = null;
        return head;
    }
}