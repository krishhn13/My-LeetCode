class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    int maxLen = -1;
    void addEdge(int src, int des) {
        if(des == -1) return;
        map.putIfAbsent(src,new ArrayList<>());
        map.get(src).add(des);
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        for(int i = 0;i < n;i++) {
            addEdge(i,edges[i]);
        }
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];   
        int[] depth = new int[n];             
        for(int i = 0;i < n;i++){
            if(!visited[i]) {
                dfs(i,0,visited,inStack,depth);
            }
        }
        return maxLen;
    }
    void dfs(int src, int d, boolean[] visited, boolean[] inStack, int[] depth) {
        visited[src] = true;
        inStack[src] = true;
        depth[src] = d;
        for(int nxt : map.getOrDefault(src,new ArrayList<>())) {
            if(nxt == -1) continue;
            if(!visited[nxt]) {
                dfs(nxt, d+1, visited, inStack, depth);
            } 
            else if(inStack[nxt]) {
                int len = d - depth[nxt] + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        inStack[src] = false;
    }
}
