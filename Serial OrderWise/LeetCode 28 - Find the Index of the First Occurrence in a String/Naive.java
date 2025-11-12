class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
public class Naive {
     public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStr("sadbutsad", "sad"));
     }   
}
