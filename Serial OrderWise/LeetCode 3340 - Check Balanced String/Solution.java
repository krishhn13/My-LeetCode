class Solution {
    public boolean isBalanced(String num) {
        int evens = 0, odds = 0;
        for(int i = 0; i < num.length(); i++) {
            if(i%2!=0) {
                odds += num.charAt(i) - '0';
            } else {
                evens += num.charAt(i) - '0';
            }
        } 
        return evens == odds;
    }
}