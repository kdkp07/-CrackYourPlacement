class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(int src , ArrayList<ArrayList<Integer>> adj,int[]vis,int parent){
        vis[src] = 1;
        for(var it : adj.get(src)){
            if(vis[it]!=1){
                if(dfs(it, adj,vis,src)){
                    return true;
                }
            }
            else if( it != parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[]vis = new int[V];
    
        for(int i =0 ; i < V; i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,-1)){
                    return true;
                }
            }
        }
        return false;
    }
}
