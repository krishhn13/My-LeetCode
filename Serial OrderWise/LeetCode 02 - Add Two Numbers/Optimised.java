// Time Complexity: O(max(n, m))
// Space Complexity: O(max(n, m)) (or O(1) extra auxiliary space, besides output list)
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode curr = temp;
        int carry = 0;
        while(l1!=null || l2!=null || carry !=0) {
            int val1 = 0;
            if(l1!=null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            int val2 = 0;
            if(l2!=null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1+val2+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }  
        return temp.next;
    }
}
public class Optimised {
         public static void main(String[] args) {
        Solution s = new Solution();

        // build first list: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // build second list: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = s.addTwoNumbers(l1, l2);

        // print result
        printList(result);
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null)
                sb.append(" -> ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
