class Solution {
    private boolean check(int start, int n, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            for(int it : graph[node]) {
                //if the adj is not yet colored
                //so give opposite color to it
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                //if the adj guy having same color
                //someone did color it on some other path
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }//TC->O(V+E),SC->O(V+E)
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                if(!check(i, n, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}