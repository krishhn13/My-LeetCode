import java.util.*;

class Solution {
        public int findShortestSubArray(int[] nums) {
                int max = Integer.MIN_VALUE;
                int ele = -1;
                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                        map.putIfAbsent(nums[i], new ArrayList<>());
                        map.get(nums[i]).add(i);
                }
                List<Integer> maxis = new ArrayList<>();
                for (int i : map.keySet()) {
                        if (map.get(i).size() > max) {
                                ele = i;
                                max = map.get(i).size();
                        }
                }
                for (int i : map.keySet()) {
                        if (map.get(i).size() == max) {
                                maxis.add(i);
                        }
                }
                // System.out.println(maxis);
                int minLen = Integer.MAX_VALUE;
                for (int elem : maxis) {
                        int mini = Integer.MAX_VALUE;
                        int maxi = Integer.MIN_VALUE;
                        for (int i : map.get(elem)) {
                                mini = Math.min(mini, i);
                                maxi = Math.max(maxi, i);
                        }
                        minLen = Math.min(minLen, maxi - mini + 1);
                }
                return minLen;
        }
}