class Solution {
        public ListNode reverseList(ListNode head) {
                ListNode temp = head;
                ListNode prev = null;
                ListNode fwd = null;
                while (temp != null) {
                        fwd = temp.next;
                        temp.next = prev;
                        prev = temp;
                        temp = fwd;
                }
                return prev;
        }
}