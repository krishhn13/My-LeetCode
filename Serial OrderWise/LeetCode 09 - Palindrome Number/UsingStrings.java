class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || x%10 == 0 && x!=0) return false;
        String s = ""+x;
        int n = s.length();
        for(int i = 0 ; i < n;i++) { 
            if(s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        return true;
    }
}
public class UsingStrings {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isPalindrome(1001));
        }       
}
