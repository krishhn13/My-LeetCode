package Serial OrderWise.LeetCode 231 - Power Of Two;
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0 ;
    }
}
public class Bitwise {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isPowerOfTwo(91));
        }
}
