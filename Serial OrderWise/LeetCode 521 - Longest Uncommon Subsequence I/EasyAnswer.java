class Solution {
    public int findLUSlength(String a, String b) {
        // if they are both equal, there is no chance of getting uncommon subsequence
        if(a.equals(b)) {
                return -1;
        }
        // now we need to return *LONGEST UNCOMMON SUBSEQUENCE*, that is the length of the greater string 
        return Math.max(a.length(),b.length());
    }
}
public class EasyAnswer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.findLUSlength("aaa", "bcbcb"));
        }       
}
