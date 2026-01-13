class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        int maxOdd = -1, minOdd = (int)1e5, maxEv = -1, minEv = (int)1e5;
        for(int i : freq) {
            if(i == 0) continue;
            if(i%2 == 0) {
                minEv = Math.min(minEv, i);
                maxEv = Math.max(maxEv, i);
            } else {
                minOdd = Math.min(minOdd, i);
                maxOdd = Math.max(maxOdd, i);
            }
        }
        if(maxOdd == -1 || minEv == (int)1e5) return 0;
        return maxOdd - minEv;
    }
}
