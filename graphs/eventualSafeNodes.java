/* 

  problem link : https://leetcode.com/problems/find-eventual-safe-states/submissions/

*/
class Solution {
    public boolean isCycle (int src , int[][] graph , boolean[] vis , boolean[] pathVis, int[] check)
    {
        vis[src] = true;
        pathVis[src]=true;
        check[src] = 0;
        for(var it : graph[src]){
            if(vis[it]==false){
                if(isCycle(it,graph,vis,pathVis,check)){
                    return true;
                }
                
            }
            else if(pathVis[it]==true){
                return true;
            }
        }
        check[src] = 1;
        pathVis[src] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        int[] check = new int[V];
        for(int i =0 ; i< V;i++){
            if(!vis[i]){
                isCycle(i,graph,vis,pathVis,check);
            }
        }
        
        for(int i = 0 ; i < V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
