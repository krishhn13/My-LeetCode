# LeetCode 70 - Climbing Stairs

## Problem
Given `n` stairs, you can climb 1 or 2 stairs at a time. Find the total number of distinct ways to reach the top.

## Approach: Memoization (Top-Down DP)

### Algorithm
- **Base Cases:**
        - If position equals `n`, return `1` (one way to reach top)
        - If position exceeds `n`, return `0` (invalid path)
- **Recurrence:** For each position `i`, ways = ways(i+1) + ways(i+2)
- **Memoization:** Store computed results in `dp` array to avoid redundant calculations

### Complexity Analysis
| Metric | Complexity |
|--------|-----------|
| Time   | O(n)      |
| Space  | O(n)      |

### Example
```
Input: n = 4
Output: 5
Explanation: Paths → [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]
```

### Note
Consider bottom-up DP for better space efficiency (O(1) space).