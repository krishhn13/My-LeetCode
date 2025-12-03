class Solution {
    public long removeZeros(long n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c !='0') sb.append(c);
        }
        return Long.parseLong(sb.toString());
    }
}