import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        // Steps:
        /*
            1. find the break-point, that is the point where your array was increasing from back, but showed dip all of the sudden
            2. find the minimum bigger value than that break value
            3. swap the minimum bigger value with the break value, and reverse the rest of the array
            4. Edge Case : If the break points seems to be unchanged, that is -1, return, that is the last permutation, sort the array and return 
        */
        // Step 1:
        int n = nums.length;
        int idx = -1;
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1]) {
                idx = i;
                break;
            }
        }

        // Handling the edge case of -1 index
        if(idx==-1) {
            int i = 0, j = n-1;
            while(i<j) {
                int temp  = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;j--;
            }
            return;
        }
        // System.out.println(idx);
        // Step 2: finding minimum bigger integer
        int mini = -1;
        for(int i = n-1;i>=0;i--) {
            if(nums[i]>nums[idx]) {
                mini = i;
                break;
            }
        }

        // Step 3: swapping the minimum bigger value with break value
        int temp = nums[mini];
        nums[mini] = nums[idx];
        nums[idx] = temp;

        // reverse the array
        int i = idx+1, j = n-1;
        while(i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
        return;
    }
}
public class NextPermutation {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = new int[]{1,2,3};
                sol.nextPermutation(arr);
                System.out.println(Arrays.toString(arr));
        } 
}
