class Solution {
    public long minimumSteps(String s) {
        long res = 0, cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') cnt++;
            else res+= cnt;
        }
        return res;
    }
}