class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] lookup = new int[26];
        for (char c : s.toCharArray()) {
            lookup[c - 'a']++;
        }
        int[] targetLookup = new int[26];
        for (char c : target.toCharArray()) {
            targetLookup[c - 'a']++;
        }
        int makeup = Integer.MAX_VALUE;
        for (char c : target.toCharArray()) {
            int idx = c - 'a';
            makeup = Math.min(makeup, lookup[idx] / targetLookup[idx]);
        }
        return makeup == Integer.MAX_VALUE ? 0 : makeup;
    }
}