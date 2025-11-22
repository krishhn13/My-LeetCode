class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) { 
                nums[i]++;
                count++;
            }       
        }
        return count;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.minimumOperations(new int[]{1,2,3,4}));
        }
}
