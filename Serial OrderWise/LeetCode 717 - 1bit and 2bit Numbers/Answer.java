class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length) {
            if(bits[i] == 1) {
                i+=2;
                if(i>=bits.length) return false;
            } else {
                i++;
            }
        }
        return true;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = {1,1,1,0};
                System.out.println(sol.isOneBitCharacter(arr));
        }
}
