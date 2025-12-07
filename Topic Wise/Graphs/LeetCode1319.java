import java.util.*;
class DS{
    int extras = 0;
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DS(int n) {
        for(int i = 0;i<=n;i+=1) {
            parent.add(i);
            size.add(1);
        }
    }
    int findPar(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int root = findPar(parent.get(node));
        parent.set(node,root);
        return root;
    }
    void union(int src, int des) {
        int pu = findPar(src);
        int pv = findPar(des);
        if(pu == pv) {
            extras+=1;
            return;
        }
        if(size.get(pu) < size.get(pv)) {
            size.set(pv,size.get(pv)+size.get(pu));
            parent.set(pu,pv);
        } else {
            size.set(pu,size.get(pu) + size.get(pv));
            parent.set(pv,pu);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DS ds = new DS(n);
        for(int i = 0;i < connections.length;i++) {
            ds.union(connections[i][0], connections[i][1]);
        }
        int extras = ds.extras;
        int cnt = 0;
        for(int i = 0;i < n;i+=1) {
            if(ds.parent.get(i) == i) cnt+=1;
        }
        if(extras>=cnt-1) return cnt-1;
        return -1;
    }
}
public class LeetCode1319 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[][] edges = {{0,1},{0,2},{1,2}};
                System.out.println(sol.makeConnected(4, edges));
        }       
}
