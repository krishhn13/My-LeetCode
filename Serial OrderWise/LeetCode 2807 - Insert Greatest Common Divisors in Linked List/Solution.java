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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while(temp.next!=null) {
            ListNode gcd = new ListNode(gcd(temp.val, temp.next.val));
            gcd.next = temp.next;
            temp.next = gcd; 
            temp = temp.next.next;
        }
        return head;
    }
    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } 
        return gcd(b, a%b);
    }
}