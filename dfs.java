class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int src, ArrayList<Integer> ans, int[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[src] = 1; 
        ans.add(src);
        for(int v : adj.get(src)){
            if(vis[v]!=1){
                dfs(v, ans,vis,adj);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        dfs(0,ans,vis, adj);
        return ans;
    }
}
