class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != a) {
                    return ans.toString(); 
                }
            }
            ans.append(a);
        }

        return ans.toString();
    }
}
public class Naive { 
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        }       
}
