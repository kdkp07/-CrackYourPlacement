// Problem link : https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#
class Solution
{
    class Pair
    {
        int node;
        int wt;
        Pair(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    
    public boolean dfs(int src , int[]vis , int[]pathVis ,List<List<Pair>> adj,int parent,int curr_wt)
    {
        vis[src] = 1;
        pathVis[src] = 1;
        for(var it : adj.get(src)){
            int node = it.node;
            int wt = it.wt;
            if(vis[node]!=1){
                if(dfs(node,vis,pathVis,adj,src,curr_wt+wt)){
                    return true;
                }
            }
            else if(pathVis[node]==1 && wt<0){
                return true;
            }
        }
        pathVis[src] = 0;
        return false;
    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i= 0 ; i<n;i++) adj.add(new ArrayList<>());
        for(int[] i : edges){
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        }
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i =0; i<n;i++){
            if(vis[i]!=1){
                if( dfs(i,vis,pathVis,adj,-1,0) ){      // found neg cycle
                    return 1;
                }
            }
        }
        // no cycle
        return 0;
    }
}
