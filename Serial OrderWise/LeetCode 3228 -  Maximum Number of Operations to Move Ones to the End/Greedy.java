class Solution {
    public int maxOperations(String s) {
        int ans = 0 , count1 = 0;
        int n = s.length();
        for(int i = 0;i<n;i++) {
            if(s.charAt(i) == '1') count1++;
            else if(i>0 && s.charAt(i-1) == '1' && s.charAt(i) == '0') {
                ans+=count1;
            }
        }
        return ans;
    }
}
public class Greedy {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.maxOperations("0011010101100"));
        }
}
