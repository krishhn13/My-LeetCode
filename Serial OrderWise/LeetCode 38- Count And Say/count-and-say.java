class Solution {
    public String countAndSay(int n) {
        String val = "1";
        for(int i = 1;i<n;i++) {
            val = next(val);
        }
        return val;
    }
    String next(String s) {
        StringBuilder str = new StringBuilder();
        int count = 1;
        for(int i = 0;i<s.length();i++) {
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)) {
                str.append(count).append(s.charAt(i));
                count = 1;
            } else count++;
        }
        return str.toString();
    }
}