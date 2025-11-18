import java.util.*;
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i < nums.length; i++) {
            if(nums[i] == 1) arr.add(i);   
        }
        for(int i=0;i<arr.size()-1;i++) {
            if((arr.get(i+1) - arr.get(i) )-1 >= k) continue;
            else return false; 
        }
        return true;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
        }
}
