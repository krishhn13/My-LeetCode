class Pair {
    char ch;
    int freq;
    int idx;
    Pair(char ch, int freq, int idx) {
        this.ch = ch;
        this.freq = freq;
        this.idx = idx;
    }
}

class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.freq != a.freq) {
                return b.freq - a.freq;
            }
            return a.idx - b.idx;
        });
        int idx = 0;
        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c), idx++));
        }
        List<Character> ordered = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int i = 0; i < p.freq; i++) {
                ordered.add(p.ch);
            }
        }
        StringBuilder str = new StringBuilder();
        int pointer = 0;
        for (char c : s.toCharArray()) {
            if (!isVowel(c)) {
                str.append(c);
            } else {
                str.append(ordered.get(pointer++));
            }
        }
        return str.toString();
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}