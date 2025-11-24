import java.util.*;
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int x = 0 ;
        for(int i : nums) {
            x = (2*x + i)%5;
            list.add(x==0);
        }
        return list;
    }
}
public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.prefixesDivBy5(new int[]{0,1,1}));
        }    
}
