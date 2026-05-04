import java.util.*;
class Solution {
    List<Integer> temp ;
    public Solution(ListNode head) {
        temp = new ArrayList<>();
        ListNode tmp = head;
        while(tmp!=null) {
            temp.add(tmp.val);
            tmp = tmp.next;
        }
    }
    public int getRandom() {
        int randomIndex = new Random().nextInt(temp.size());
        return temp.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */