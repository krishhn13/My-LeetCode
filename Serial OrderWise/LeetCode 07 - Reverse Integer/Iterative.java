class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        long ans = 0;
        while(num > 0) {
                ans = ans*10 + (num%10);
                if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
                num/=10;
        }
        if(x<0) return (int)ans*-1;
        return (int)ans;
    }
}

public class Iterative {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.reverse(1534236469));
        }        
}
