// problem link : https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#
class Solution
{
    public boolean helper(int src , int[][] edges, int n){
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
      
            for(int i = 0; i <n-1;i++){
                for(var it : edges){
                    int u = it[0];
                    int v = it[1];
                    int wt = it[2];
                    
                    if(dist[u]!=1e9 && dist[v]>dist[u]+wt){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
            
            // nth relaxation
            for(var it : edges){
                int u = it[0];
                    int v = it[1];
                    int wt = it[2];
                    
                    if(dist[u]!=1e9 && dist[v]>dist[u]+wt){
                        return true;
                    }
            }
            return false;
    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
    
        for(int i =0; i <n;i++){
            if(helper(i,edges,n)) return 1;
        }
        return 0;
    }
}
