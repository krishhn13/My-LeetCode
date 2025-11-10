// Time: O(n + m) , Space: O(n + m)

//  Definition for singly-linked list.
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
    ListNode insertAtHead(ListNode head, int data) {
        ListNode temp = new ListNode(data);
        temp.next = head;
        return temp;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, forward = null;
        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while (l1 != null) {
            num1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            num2.append(l2.val);
            l2 = l2.next;
        }

        // Convert StringBuilder to character array and do addition manually
        char[] n1 = num1.toString().toCharArray();
        char[] n2 = num2.toString().toCharArray();

        int i = n1.length - 1, j = n2.length - 1, carry = 0;
        ListNode head3 = null;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? (n1[i--] - '0') : 0;
            int digit2 = (j >= 0) ? (n2[j--] - '0') : 0;
            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            head3 = insertAtHead(head3, sum % 10);
        }

        return reverse(head3);
    }
}

public class Naive {
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
