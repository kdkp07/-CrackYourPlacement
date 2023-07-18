problem link : https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution
{
    private boolean dfs(int src, int[] vis , ArrayList<ArrayList<Integer>>adj,int[]color){
        vis[src] = 1;
        for(int it : adj.get(src)){
            if(vis[it]==0){
                vis[it] = 1;
                color[it] = 1 - color[src];
                if(!dfs(it,vis,adj,color)){
                    return false;
                }
            }
            else if(color[src]==color[it]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        int[] vis = new int[V];
        for(int i = 0 ; i < V ; i++){
            if(vis[i]==0){
                if(!dfs(i,vis,adj,color)){
                    return false;
                }
            }
        }
        return true;
    }
}
