import java.util.Arrays;
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2; 
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = nums[i] - i;
        }
        Arrays.sort(transformed); 
        long goodPairs = 0;
        long count = 1;
        for (int i = 1; i < n; i++) {
            if (transformed[i] == transformed[i - 1]) {
                count++;
            } else {
                goodPairs += (count * (count - 1)) / 2; 
                count = 1; 
            }
        }
        goodPairs += (count * (count - 1)) / 2; 
        return totalPairs - goodPairs;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.countBadPairs(new int[]{4,1,3,3}));
        }
}
