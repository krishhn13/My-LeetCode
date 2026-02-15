import java.util.*;
class Pair{
    String word;
    int level;
    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList) {
            set.add(s);
        }
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        if(set.contains(beginWord)) set.remove(beginWord);
        q.add(new Pair(beginWord,1));
        int ans = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int level = p.level;
            if(word.equals(endWord)) return level;
            for(int i = 0;i < word.length();i++) {
                for(char c = 'a';c<='z';c++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = c;
                    String prob = new String(charArray);
                    if(set.contains(prob)) {
                        set.remove(prob);
                        q.add(new Pair(prob,level+1));
                    }
                }
            }
        }
        return 0;
    }
}