// problem link : https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
class Solution
{
    public void dfs(int src, int[] vis ,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[src] =1;
        for(int it : adj.get(src)){
            if(vis[it]==0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(src);
    }
    
    public void dfs2(int src, int[] vis , ArrayList<ArrayList<Integer>> adjReverse ){
        vis[src] =1;
        for(int it : adjReverse.get(src)){
            if(vis[it]==0){
                dfs2(it,vis,adjReverse);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //sort based on finishing time ,
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < V ; i++){
            if(vis[i]==0){
                dfs(i,vis, adj, st);
            }
        }
        // reverse the graph
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        for(int i =0 ; i < V ;i++){
            adjReverse.add(new ArrayList<>());
        }
        for(int i = 0; i<V;i++){
            vis[i] =0;
            for(int it : adj.get(i)){
                adjReverse.get(it).add(i);
            }
        }
        int scc =0 ; 
        // do dfs on reversed graph and scc will be number of times dfs got executed.
        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node]==0){
                scc++;
                dfs2(node ,vis , adjReverse);
            }
        }
        return scc;
    }
}
