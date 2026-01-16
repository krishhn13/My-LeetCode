
class Solution {
        public boolean isPowerOfTwo(int n) {
                if (n == 1)
                        return true;
                if (n % 2 != 0) {
                        return false;
                }
                while (n > 2) {
                        if (n % 2 != 0) {
                                return false;
                        }
                        n /= 2;
                }
                return n == 2;
        }

}

public class Iterative {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isPowerOfTwo(1920));
        }
}
