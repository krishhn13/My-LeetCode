class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode revHead = reverse(head); 
        int maxi = revHead.val;
        ListNode curr = revHead;
        while (curr != null && curr.next != null) {
            if (curr.next.val < maxi) {
                curr.next = curr.next.next; 
            } else {
                curr = curr.next;
                maxi = curr.val;
            }
        }
        return reverse(revHead);
    }
    private ListNode reverse(ListNode head) {
        ListNode temp = head, prev = null;
        while(temp != null) {
            ListNode fwd = temp.next;
            temp.next = prev;
            prev = temp;
            temp = fwd;
        }
        return prev;
    }
}