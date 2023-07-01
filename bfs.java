
class Solution {
    // Function to return Breadth First Traversal of given graph.
  
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = 1;
        ans.add(0);
        while(q.size()!=0){
            int src = q.poll();
    
            for(int v : adj.get(src)){
                if(vis[v]!=1){
                    vis[v] = 1 ;
                    q.offer(v);
                    ans.add(v);
                }
            }
            
        }
        
        return ans;
    }
}
