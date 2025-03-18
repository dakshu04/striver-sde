class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int cnt = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!vis[i]) {
                dfs(i, isConnected, vis);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int i, int[][] isConnected, boolean[] vis) {
        vis[i] = true;
        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && vis[j] == false){
                dfs(j, isConnected, vis);
            }
        }
    }
}