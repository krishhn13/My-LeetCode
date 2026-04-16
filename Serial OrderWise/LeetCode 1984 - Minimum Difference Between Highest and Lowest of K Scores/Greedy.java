import java.util.*;
class Solution {
                public int minimumDifference(int[] nums, int k) {
                        if (k == 1)
                                return 0;
                        Arrays.sort(nums);
                        int diff = (int) 1e9;
                        int n = 0;
                        while (n <= nums.length - k) {
                                int mini = nums[n];
                                int maxi = nums[n + k - 1];
                                diff = Math.min(diff, maxi - mini);
                                n++;
                        }
                        return diff;
                }
        }


public class Greedy {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                if (!sc.hasNextInt()) {
                        sc.close();
                        return;
                }

                int n = sc.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                        nums[i] = sc.nextInt();
                }
                int k = sc.nextInt();

                Solution sol = new Solution();
                System.out.print(sol.minimumDifference(nums, k));

                sc.close();
        }
}
