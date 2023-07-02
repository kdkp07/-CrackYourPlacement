// Problem link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean helper(int src , int[] vis,int[] dfsVis , ArrayList<ArrayList<Integer>> adj){
        vis[src] = 1;
        dfsVis[src]=1;
        for(int v : adj.get(src)){
            if(vis[v]!=1){
                if(helper(v,vis,dfsVis,adj)){
                    return true;
                }
            }
            else if (dfsVis[v]==1){
                return true;
            }
        }
        dfsVis[src] = 0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        int[] dfsVis = new int[V];
        for(int i =0 ; i < V;i++){
            if(vis[i]==0){
                if(helper(i,vis,dfsVis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
}
