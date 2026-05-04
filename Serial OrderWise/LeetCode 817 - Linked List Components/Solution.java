class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp.val)) {
                count++;
                while (temp != null && set.contains(temp.val)) {
                    temp = temp.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return count;
    }
}