import java.util.*;

class Solution {
        public List<Long> mergeAdjacent(int[] nums) {
                Stack<Long> stack = new Stack<>();
                for (long i : nums) {
                        if (stack.isEmpty()) {
                                stack.push(i);
                        } else {
                                if (stack.peek() == i) {
                                        stack.pop();
                                        long ele = i * 2;
                                        while (!stack.isEmpty() && stack.peek() == ele) {
                                                stack.pop();
                                                ele *= 2;
                                        }
                                        stack.push(ele);
                                } else {
                                        stack.push(i);
                                }
                        }
                }
                return new ArrayList<>(stack);
        }
}