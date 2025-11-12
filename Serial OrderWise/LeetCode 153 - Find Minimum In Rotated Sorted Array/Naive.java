class Solution {
    public int findMin(int[] nums) {
        int mini = Integer.MAX_VALUE;
        for(int i : nums) {
            mini = mini < i? mini : i;
        }
        return mini;
    }
}
public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.findMin(new int[]{4,5,6,7,1,2,3}));
        }
}
