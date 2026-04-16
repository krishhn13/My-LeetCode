class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
                int m = 0, g = 0, p = 0;
                int lastM = 0, lastG = 0, lastP = 0;
                for (int i = 0; i < garbage.length; i++) {
                        for (char c : garbage[i].toCharArray()) {
                                if (c == 'M') {
                                        m++;
                                        lastM = i;
                                } else if (c == 'G') {
                                        g++;
                                        lastG = i;
                                } else {
                                        p++;
                                        lastP = i;
                                }
                        }
                }
                int[] pre = new int[travel.length + 1];
                pre[0] = 0;
                for (int i = 1; i <= travel.length; i++) {
                        pre[i] = pre[i - 1] + travel[i - 1];
                }
                return m + g + p + pre[lastM] + pre[lastG] + pre[lastP];
        }
}