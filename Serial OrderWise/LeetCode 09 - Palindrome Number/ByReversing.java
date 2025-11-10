class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int y = x;
        int num = 0;
        while(x>0) {
            num=num*10+(x%10);
            x/=10;
        }
        return y==num; 
    }
}
public class ByReversing {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isPalindrome(-9788879));
        }   
}
