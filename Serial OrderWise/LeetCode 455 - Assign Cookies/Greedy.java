import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int i = 0  ,j = 0, count = 0;
        while(i<g.length && j<s.length) {
            if(s[j] >= g[i]) {
                count++; j++; i++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
public class Greedy {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] greed = {1,2,3};
                int[] size = {1,1};
                System.out.println(sol.findContentChildren(greed, size));
        }
}
