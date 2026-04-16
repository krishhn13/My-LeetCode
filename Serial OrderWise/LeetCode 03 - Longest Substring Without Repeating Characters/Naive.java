import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxi = 0; 
        for(int right = 0 ; right<s.length();right++) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxi = maxi > right-left+1 ? maxi : right - left + 1;
        }  
        return maxi;
    }
}

public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                String str = new String("KrishanKumarSah");
                System.out.println(sol.lengthOfLongestSubstring(str));
        }
}
