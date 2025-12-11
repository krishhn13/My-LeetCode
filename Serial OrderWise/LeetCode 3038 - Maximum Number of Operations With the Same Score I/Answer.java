class Solution {
    public int maxOperations(int[] nums) {
        int cnt = 1;
        int score = nums[0]+nums[1];
        for(int i = 2;i < nums.length-1;i+=2) {
            int abhi = nums[i]+nums[i+1];
            if(score == abhi) cnt++;
            else break;
        }
        return cnt;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = {5,2};
                System.out.println(sol.maxOperations(arr));
        }
}
