class Solution {
    public int[] minOperations(int[] nums) {
        boolean[] h = new boolean[5001];
        for(int i = 1;i < 5000;i++) {
            h[i]=check(i);
        }
        int[] ans = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            int n = nums[i];
            int d = 0;
            while(true){
                if(n-d>=1 && h[n-d]){
                    ans[i]=d;
                    break;
                } 
                if(n+d<=5000 && h[n+d]){
                    ans[i]=d;
                    break;
                }
                d+=1;
            }
        }
        return ans;
    }
    boolean check(int n) {
        String s = Integer.toBinaryString(n);
        int l = 0 ,r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.minOperations(new int[]{1,2,4}));
        }       
}
