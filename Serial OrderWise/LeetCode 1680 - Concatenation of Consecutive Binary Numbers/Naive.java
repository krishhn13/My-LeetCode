class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        int ans = 0;
        int mod = (int)1e9+7;
        for (int i = 0; i < sb.length(); i++) {
            ans = (ans * 2 + (sb.charAt(i) - '0'))%mod;
        }
        return (int)(ans%mod);
    }
}

public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.concatenatedBinary(6));
        }
}