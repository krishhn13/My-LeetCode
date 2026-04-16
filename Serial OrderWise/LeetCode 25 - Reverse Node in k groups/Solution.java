class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
                if (head == null)
                        return null;
                ListNode temp = head;
                int count = 0;
                while (count < k) {
                        if (temp == null)
                                return head;
                        temp = temp.next;
                        count++;
                }
                ListNode prev = null;
                temp = head;
                ListNode forward = null;
                count = 0;
                while (count < k) {
                        forward = temp.next;
                        temp.next = prev;
                        prev = temp;
                        temp = forward;
                        count++;
                }
                head.next = reverseKGroup(forward, k);
                return prev;
        }
}
