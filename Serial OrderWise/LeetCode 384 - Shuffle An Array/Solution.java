class Solution {
    int[] arr, org;
    int n;
    public Solution(int[] nums) {
        n = nums.length;
        arr = Arrays.copyOf(nums, n);
        org = Arrays.copyOf(nums, n);
    }
    
    public int[] reset() {
        arr = Arrays.copyOf(org, n);
        return arr;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        int min = 0, max = n-1;
        for(int i = 0; i < n; i++) {
            int idx = rand.nextInt(max - min + 1) + min;
            int ele = arr[idx];
            arr[idx] = arr[i];
            arr[i] = ele;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */