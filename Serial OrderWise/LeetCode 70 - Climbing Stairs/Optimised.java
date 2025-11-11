class Solution {
        public int climbStairs(int n) {
                if (n <= 3) {
                        return n;
                }
                int first = 2;
                int second = 3;
                for (int i = 4; i < n; i += 1) {
                        int curr = first + second;
                        first = second;
                        second = curr;
                }
                return second;
        }
}

public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.climbStairs(5));
        }
}
