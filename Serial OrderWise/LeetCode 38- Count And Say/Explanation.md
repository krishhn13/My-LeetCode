# LeetCode 38 - Count and Say

## Problem Statement
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
- `countAndSay(1) = "1"`
- `countAndSay(n)` is the way you would "say" the digits of `countAndSay(n-1)`

## Solution Approach
We build the sequence iteratively, where each iteration applies the `next()` function to generate the next term by counting consecutive digits.

## Code

```java []
class Solution {
        public String countAndSay(int n) {
                String val = "1";
                for(int i = 1; i < n; i++) {
                        val = next(val);
                }
                return val;
        }
        
        String next(String s) {
                StringBuilder str = new StringBuilder();
                int count = 1;
                for(int i = 0; i < s.length(); i++) {
                        if(i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                                str.append(count).append(s.charAt(i));
                                count = 1;
                        } else {
                                count++;
                        }
                }
                return str.toString();
        }
}
```

## Complexity
- **Time:** O(n × m) where m is the length of the result
- **Space:** O(m) for the StringBuilder
