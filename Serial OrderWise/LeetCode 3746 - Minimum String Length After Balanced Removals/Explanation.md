### Approach

- Since each valid removal deletes exactly one `'a'` and one `'b'`, the total number of removals is limited by the smaller of the two counts.
- After removing all possible opposite pairs, only the majority character (all `'a'` or all `'b'`) can remain.
- Therefore, the final length is the absolute difference between the counts of `'a'` and `'b'`.

### Algorithm
1. Count how many `'a'` and `'b'` characters are in the string.
2. Return `abs(aCount - bCount)`.

### Correctness (Why it works)
- Each removal decreases both `aCount` and `bCount` by `1`, so the difference `(aCount - bCount)` stays unchanged.
- The process stops only when one of the counts becomes `0`, meaning no more pairs can be removed.
- At that point, the remaining characters are exactly the excess of the majority character, which is `|aCount - bCount|`.

### Complexity
- **Time:** `O(n)` — single pass through the string.
- **Space:** `O(1)` — only two counters.

### Reference Implementation (Java)

```java []
class Solution {
        public int minimumStringLength(String s) {
                int aCount = 0, bCount = 0;

                for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == 'a') aCount++;
                        else bCount++;
                }

                return Math.abs(aCount - bCount);
        }
}
```
