class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[]arr = new boolean[27];
        arr[0] = true;
        for(char c : sentence.toCharArray()) {
                arr[c-'a'+1] = true;
        }
        for(boolean t : arr) {
                if(!t) return false;
        }
        return true;
    }
}
public class Optimised {
        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.checkIfPangram("krishn"));
        }
}
