import java.util.*;
class Solution {
        public int lengthOfLongestSubstring(String s) {
                int[] arr = new int[256];
                Arrays.fill(arr,-1);
                int left = 0, right = 0, maxi = 0;
                int n = s.length();
                while(right < n) {
                        char ch = s.charAt(right);
                        if(arr[ch]!=-1 && arr[ch]>=1) {
                                left = arr[ch]+1;
                        }
                        arr[ch] = right;
                        maxi = Math.max(maxi, right-left+1);
                        right++;
                }
                return maxi;
        }
}

public class EvenBetter {
        public static void main(String[] args){
                Solution sol = new Solution();
                String str = "KrishanKumarSah";
                System.out.println(sol.lengthOfLongestSubstring(str));
        }
}
