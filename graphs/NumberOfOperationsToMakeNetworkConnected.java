class Solution {
    public void dfs(int src , List<List<Integer>> adj , boolean[] vis){
        vis[src]=true;
        for(int it : adj.get(src)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
        return;
    } 
    public int makeConnected(int n, int[][] connections) {
        int e = connections.length;
        if ( e < n-1) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i =0 ; i < n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0 ; i < e ; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                count++;
            }
        }
        return count-1;
    }
}
