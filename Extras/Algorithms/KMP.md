Hi Everyone, 
This is Krishan Kumar Sah, your host for this repository, and today (February 23, 2026) we are going to discuss the KMP (Knuth-Morris-Pratt) algorithm (because I just came across it today), which is a powerful string matching algorithm used to find occurrences of a pattern within a text efficiently.

What happens is imagine yourself having two strings, say 
        String str1 = "ababcababcabc";
        String str2 = "abc";

Now what you are supposed to do is find the number of times str2 occurs in str1, and the naive way to do this is to check for each character of str1 if it matches with the first character of str2, and if it does then check for the next character and so on, but this approach can be inefficient, especially for larger strings.

The time complexity of the naive approach can be O(n*m) in the worst case, where n is the length of str1 and m is the length of str2. This is because in the worst case, you might have to check every character of str1 against every character of str2.

Now if you are sitting in an interview and you are asked such a question, and if by chance you don't know about the KMP algorithm, you might end up writing the naive approach, which can lead to a time limit exceeded error for larger inputs, and eventually your selection might be at stake.

So to avoid such situations, it's crucial to understand and implement the KMP algorithm, which can find all occurrences of str2 in str1 in O(n + m) time, making it much more efficient than the naive approach.

The KMP algorithm works by preprocessing the pattern (str2) to create a longest prefix-suffix (LPS) array, which helps in skipping unnecessary comparisons when a mismatch occurs. The LPS array indicates the longest proper prefix of the pattern that is also a suffix, allowing the algorithm to avoid re-checking characters that have already been matched.

Longest prefix suffix requires the prefix to be a proper prefix, that it should not be equal to the string itself, and it should also be a suffix of the string. For example, in the string "abcab", the longest prefix that is also a suffix is "ab", which has a length of 2.

Also the str of len 1 is also supposed to have the longest prefix suffix of 0, because the only prefix and suffix it has is itself, which is not a proper prefix or suffix.

Now coming up to the KMP, what we need to do is to find the LONGEST PREFIX SUFFIX for the pattern (str2) and then use that information to efficiently search for the pattern in the text (str1).

Here is a simple implementation of the KMP algorithm in Java:
```java[]
public class KMP {
    public static void main(String[] args) {
        String str1 = "ababcababcabc";
        String str2 = "abc";
        int count = kmpSearch(str1, str2);
        System.out.println("Number of occurrences: " + count);
    }

    public static int kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern
        int count = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                count++;
                j = lps[j - 1]; // continue searching for the next match
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}```

In this implementation, the `kmpSearch` method uses the LPS array to efficiently search for the pattern in the text, while the `computeLPSArray` method constructs the LPS array for the given pattern.

When you run this code with the provided strings, it will output:
```
Number of occurrences: 3
```
This indicates that the pattern "abc" occurs 3 times in the text "ababcababcabc".

I hope this explanation helps you understand the KMP algorithm and its implementation. If you have any questions or need further clarification, feel free to ask!

You can connect with me on LinkedIn: https://www.linkedin.com/in/krishn13/ and also check out my GitHub repository for more algorithms and data structures. 

KEEP LEARNING, KEEP CODING!

Remember coding is like a puzzle, and every algorithm you learn is a new piece that helps you solve bigger and more complex problems. So keep practicing and exploring new algorithms to enhance your problem-solving skills!