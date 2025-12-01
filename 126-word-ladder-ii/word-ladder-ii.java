class Solution {
    String b;
    List<List<String>> list = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String st : wordList) {
            set.add(st);
        }
        if(!set.contains(endWord)) {
            return list;
        }
        if(set.contains(beginWord)) {
            set.remove(beginWord);
        }
        int level = 0;
        b = beginWord;
        Queue<String> q = new ArrayDeque<>();
        map.put(b,level);
        q.add(b);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size --> 0){
                String val = q.poll();
                if(val.equals(endWord)) {
                    map.put(val,level);
                    break;
                }
                for(int i =0 ;i < val.length();i++) {
                    for(char c = 'a';c<='z';c++) {
                        char[] charSeq = val.toCharArray();
                        charSeq[i] = c;
                        String aalu = new String(charSeq);
                        if(set.contains(aalu)) {
                            map.put(aalu,level+1);
                            q.add(aalu);
                            set.remove(aalu);
                        }
                    }
                }
            }
            level += 1;
        }
        if(map.containsKey(endWord)) {
            List<String> rip = new ArrayList<>();
            rip.add(endWord);
            dfs(endWord,rip);
        }
        return list;
    }
    private void dfs(String str , List<String> rip) {
        if(str.equals(b)) {
            List<String> pir = new ArrayList<>(rip);
            Collections.reverse(pir);
            list.add(pir);
            return;
        }
        for(int i = 0 ; i < str.length();i++) {
            char[] charSeq = str.toCharArray();
            for(char c = 'a';c<='z';c++) {
                charSeq[i] = c;
                String s = new String(charSeq);
                if(map.containsKey(s) && map.get(s)+1 == map.get(str)) {
                    rip.add(s);
                    dfs(s,rip);
                    rip.remove(rip.size()-1);
                }
            }
        }
    }
}