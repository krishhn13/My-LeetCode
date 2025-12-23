import java.util.*;
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int i = 0;
        long score = 0;
        Set<Integer> visited = new HashSet<>();
        while (i >= 0 && i < instructions.length && !visited.contains(i)) {
            visited.add(i);
            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            } else if (instructions[i].equals("jump")) {
                i += values[i];
            } else {
                break;
            }
        }
        return score;
    }
}
