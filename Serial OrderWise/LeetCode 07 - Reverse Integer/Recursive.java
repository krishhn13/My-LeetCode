class Solution {
    int result = 0;
    public int reverse(int x) {
        if (x > -10 && x < 10) {
            long temp = (long) result * 10 + x;
            return (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) ? 0 : (int) temp;
        }
        result = result * 10 + (x % 10);
        return reverse(x / 10);
    }
}
public class Recursive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.reverse(324567543));
        }
}
