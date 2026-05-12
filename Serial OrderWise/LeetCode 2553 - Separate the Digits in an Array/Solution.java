class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder str = new StringBuilder();
        for(int i : nums) {
            str.append(i);
        }
        int[] ans = new int[str.length()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = str.charAt(i) - '0';
        }
        return ans;
    }
}