import java.util.Arrays;
class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;
        int[] compare = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                int[] temp = Arrays.copyOf(nums, nums.length);
                int[] left = check(temp, i, true);
                temp = Arrays.copyOf(nums, nums.length);
                int[] right = check(temp, i, false);
                if (Arrays.equals(compare, left)){
                    count++;
                }
                if (Arrays.equals(compare, right)){
                    count++;
                }
            }
        }
        return count;
    }
    int[] check(int[] arr, int idx, boolean left){
        while (idx > -1 && idx < arr.length){
            if (arr[idx] == 0){
                if (left){
                    idx--;
                }
                else{
                    idx++;
                }
                continue;
            }
            arr[idx]--;
            if (left){
                left = false;
                idx++;
            }
            else{
                left = true;
                idx--;
            }
        }
        return arr;
    }
}