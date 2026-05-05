class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int len = 1;
        if(k == 0) {
            return head;
        }
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }
        temp.next = head;
        k %= len;
        if(k == 0) {
            temp.next = null;
            return head;
        }
        temp = head;
        int cnt = 0;
        while(cnt < len-k-1) {
            temp = temp.next;
            cnt++;
        }
        ListNode curr = temp.next;
        temp.next = null;
        return curr;
    }
}