import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[]ss = s.toCharArray();
        char[]tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return (new String(ss).equals(new String(tt)));
    }
}
public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isAnagram("car", "rca"));
        }
}
