## Approach (LeetCode style)

We need the **two largest absolute values** in the array.  
Scan once, keep track of the largest (`max1`) and second largest (`max2`) absolute values, then return:

`max1 * max2 * 100000`

### Steps
1. Initialize `max1 = 0`, `max2 = 0`.
2. For each number `x` in `nums`:
        - Set `x = abs(x)`.
        - If `x > max1`: update `max2 = max1`, `max1 = x`.
        - Else if `x > max2`: update `max2 = x`.
3. Return `max1 * max2 * 100000L`.

### Notes
- If the array has fewer than 2 elements, or all values are `0`, the result will be `0`.
- `Math.abs(Integer.MIN_VALUE)` overflows in Java and stays negative; handle separately if needed.

### Complexity
- **Time:** `O(n)` (single pass)
- **Space:** `O(1)`

### Java snippet
```java []
long max1 = 0, max2 = 0;

for (int v : nums) {
         long x = Math.abs((long) v); // use long to avoid abs(int) overflow in most cases
         if (x > max1) {
                  max2 = max1;
                  max1 = x;
         } else if (x > max2) {
                  max2 = x;
         }
}

return max1 * max2 * 100000L;
```
