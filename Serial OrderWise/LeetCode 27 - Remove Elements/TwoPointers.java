class Solution {
    public int removeElement(int[] nums, int val) {
       int index = 0;
        for (int i : nums) 
        {
            if (i != val) 
            {
                nums[index++] = i;
            }
        }
        return index;
    }
}
public class TwoPointers {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.removeElement(new int[]{3,2,2,3}, 3));
        }
}
