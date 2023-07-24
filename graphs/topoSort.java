// Problem link : https://practice.geeksforgeeks.org/problems/topological-sort/1
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static void dfs(int src ,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> st,boolean[]dfsVis,boolean isPossible){
        vis[src] = true;
        dfsVis[src] = true;
        for(var it : adj.get(src)){
            if(vis[it]==false){
                dfs(it,adj,vis,st,dfsVis,isPossible);
            }
            else if(dfsVis[it]==true){
                isPossible = false;
            }
        }
        st.push(src);
        dfsVis[src]= false;
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];
        boolean isPossible = true;
        Stack<Integer> st = new Stack<>();
        for(int i =0; i <V;i++){
            if(vis[i]==false){
                dfs(0,adj,vis,st,dfsVis,isPossible);
            }
        }
        int[] ans = new int[V];
        if(!isPossible) return new int[0];
        int idx =0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        return ans;
    }
}
