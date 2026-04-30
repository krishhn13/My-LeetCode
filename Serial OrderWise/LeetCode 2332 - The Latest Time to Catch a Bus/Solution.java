import java.util.*;
class Solution {
    public int latestTimeCatchTheBus(int[] b, int[] p, int c) {
        Arrays.sort(b);
        Arrays.sort(p);

        ArrayList<Integer> last = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < b.length; i++) {
            int cap = c;
            while (j < p.length && p[j] <= b[i] && cap > 0) {
                if (i == b.length - 1) {
                    last.add(p[j]); 
                }
                cap--;
                j++;
            }
        }
        int l;
        if (last.size() < c) {
            l = b[b.length - 1]; 
        } else {
            l = last.get(last.size() - 1) - 1;
        }

        while (true) {
            boolean clash = false;
            for (int i = 0; i < p.length; i++) {
                if (p[i] == l) {
                    l--; 
                    clash = true;
                    break;
                }
            }
            if (!clash) break;
        }

        return l;
    }
}
