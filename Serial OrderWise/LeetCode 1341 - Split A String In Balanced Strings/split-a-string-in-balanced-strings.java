class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int balance = 0;
        for(char c : s.toCharArray()) {
            if(c == 'L') balance+=1;
            else balance-=1;
            if(balance == 0) ans+=1;
        }
        return ans;
    }
}