class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] prob = sort(nums1,nums2);
        int mid = prob.length/2;
        if(prob.length%2 == 0) {
                return (prob[mid-1]+prob[mid])/2.0;
        } else {
                return prob[mid];
        }
    }
    private int[] sort(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int i = 0, j = 0, idx = 0;
        while(i < nums1.length && j < nums2.length) {
                if(nums1[i] < nums2[j]) {
                        ans[idx] = nums1[i];
                        i++;
                } else {
                        ans[idx] = nums2[j];
                        j++;
                }
                idx++;
        }
        while(i < nums1.length) {
                ans[idx++] = nums1[i++];
        }
        while(j < nums2.length) {
                ans[idx++] = nums2[j++];
        }
        return ans;
    }
}
public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] nums1 = {19,23,25,26,78};
                int[] nums2 = {12,23,34,45,56};
                System.out.println(sol.findMedianSortedArrays(nums1, nums2));
        }
}
