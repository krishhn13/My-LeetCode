## LeetCode 1200 — Minimum Absolute Difference

### Intuition
We need all pairs **(a, b)** such that the absolute difference is minimum among all possible pairs.

A key observation:
- After sorting, the smallest absolute difference must occur between **two adjacent elements**.
  - If `arr[i] <= arr[j] <= arr[k]`, then `arr[k] - arr[i]` is always **>=** at least one of `(arr[j] - arr[i])` or `(arr[k] - arr[j])`.
  - So we only need to check neighbors in the sorted array.

### Approach
1. **Sort** the array.
2. First pass: compute the minimum adjacent difference `mini`.
3. Second pass: collect every adjacent pair whose difference equals `mini`.

This matches the reference code: one loop to find `mini`, another loop to build the answer list.

### Algorithm
1. Sort `arr`.
2. Initialize `mini` to a very large value.
3. For `i` from `1` to `n-1`:
   - Update `mini = min(mini, arr[i] - arr[i-1])`.
4. Create `ans` as a list of pairs.
5. For `i` from `1` to `n-1`:
   - If `arr[i] - arr[i-1] == mini`, add `[arr[i-1], arr[i]]` to `ans`.
6. Return `ans`.

### Why it works
- Sorting ensures numbers are in non-decreasing order.
- Any non-adjacent pair has at least one element between them, and the difference across the ends cannot be smaller than the smallest adjacent gap inside that range.
- Therefore, the global minimum absolute difference is found among adjacent elements only.
- The second pass collects all such adjacent pairs, which is exactly what the problem asks.

### Complexity
- Sorting: `O(n log n)`
- Two linear passes: `O(n)`
- Total time: `O(n log n)`
- Extra space (excluding output): `O(1)` / `O(log n)` depending on sorting implementation

### Reference Code (Java)
```java
class Solution {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		int mini = (int) 1e9;
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			mini = Math.min(mini, arr[i] - arr[i - 1]);
		}
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] == mini) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i - 1]);
				list.add(arr[i]);
				ans.add(new ArrayList<>(list));
			}
		}
		return ans;
	}
}
```
