class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> sol = new ArrayList<>();
        dfs(1, n, sol);
        return sol;
    }

    void dfs(int temp, int n,List<Integer> sol) {
        if (temp > n) return;
        sol.add(temp);
        dfs(temp * 10, n, sol);
        if (temp % 10 != 9) dfs(temp + 1, n, sol);
    }
}