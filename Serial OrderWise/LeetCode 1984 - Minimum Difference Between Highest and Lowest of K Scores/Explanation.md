# LeetCode 1984 — Minimum Difference Between Highest and Lowest of K Scores

## Intuition
To minimize the difference between the highest and lowest scores among any group of `k` students, it is best to consider groups where the scores are “close” together. Sorting the array makes such groups appear as **contiguous windows** of length `k`.

## Approach (as in the given `Solution`)
1. **Handle edge case**:  
        If `k == 1`, any single score has difference `0`, so return `0`.
2. **Sort `nums`** in non-decreasing order.
3. Slide a window of size `k` across the sorted array:
        - For a window starting at index `n`, the minimum is `nums[n]` and the maximum is `nums[n + k - 1]`.
        - Compute `maxi - mini` and keep the smallest value across all windows.
4. Return the minimum difference found.

## Why sorting works
After sorting, the minimum and maximum of any chosen `k` elements that minimize the range will occur within some contiguous block of length `k`.  
Any non-contiguous selection can be “tightened” into a contiguous window without increasing the range, since values between chosen elements are within the same bounds.

## Algorithm
- If `k == 1`, return `0`.
- Sort `nums`.
- Initialize `diff` to a large number.
- For each `n` from `0` to `nums.length - k`:
  - `mini = nums[n]`
  - `maxi = nums[n + k - 1]`
  - `diff = min(diff, maxi - mini)`
- Return `diff`.

## Complexity
- Sorting: `O(N log N)`
- Sliding window scan: `O(N)`
- Total time: `O(N log N)`
- Extra space: `O(1)` (ignoring sort implementation details)

## Reference Implementation (Java)
```java []
class Solution {
         public int minimumDifference(int[] nums, int k) {
                  if (k == 1) return 0;

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
```