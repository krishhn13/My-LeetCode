/**
 * LeetCode-style explanation (LC 3746: Min Length After Removals)
 *
 * <p><b>Idea</b>:
 * Each removal can eliminate one {@code 'a'} and one {@code 'b'} as a pair. Therefore, the
 * maximum number of removals is limited by the smaller count among {@code 'a'} and {@code 'b'}.
 * After removing all possible opposite pairs, the remaining string (if any) consists only of the
 * majority character, and its length equals the difference between the two counts.
 *
 * <p><b>Approach</b>:
 * <ol>
 *   <li>Count occurrences of {@code 'a'} and {@code 'b'}.</li>
 *   <li>Return {@code |count('a') - count('b')|}.</li>
 * </ol>
 *
 * <p><b>Why it works</b>:
 * Removing one {@code 'a'} and one {@code 'b'} decreases both counts by 1, keeping the difference
 * {@code (aCount - bCount)} invariant. When no more pairs can be removed, one of the counts is 0,
 * so the remaining length must be the absolute difference.
 *
 * <p><b>Complexity</b>:
 * Time: {@code O(n)} to scan the string once.  
 * Space: {@code O(1)} extra space.
 */

public class Solution {
        /**
         * Given a string consisting only of 'a' and 'b', repeatedly remove any balanced pair
         * (one 'a' and one 'b') until no more such removals are possible.
         *
         * <p>The remaining length equals the absolute difference between counts of 'a' and 'b'.</p>
         */
        public int minimumStringLength(String s) {
                int aCount = 0, bCount = 0;
                for (int i = 0; i < s.length(); i++) {
                        char ch = s.charAt(i);
                        if (ch == 'a') aCount++;
                        else bCount++;
                }
                return Math.abs(aCount - bCount);
        }
}