class Solution {
    public int minMoves(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for(int i : nums) {
            maxi = maxi > i ? maxi : i; 
        }
        int ans = 0;
        for(int i : nums) {
            ans+=(maxi-i);
        }
        return ans;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol =  new Solution();
                System.out.println(sol.minMoves(new int[]{2,1,3}));
        }
}
