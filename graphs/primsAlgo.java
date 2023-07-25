// Problem link : https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
class Solution{
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    List<List<Tuple>> adj = new ArrayList<>();
	    for(int i = 0; i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(var it : edges){
	        adj.get(it[0]).add(new Tuple(it[1],it[2]));
	        adj.get(it[1]).add(new Tuple(it[0],it[2]));
	    }
	  
	    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>( (x,y) -> x.wt - y.wt);
	    pq.add(new Tuple(0,0));
	    int[] vis = new int[V];
	    int mst =0;
	    while(!pq.isEmpty()){
	        Tuple t = pq.poll();
	        int node = t.node;
	        if(vis[node]==1) continue;
	        mst += t.wt;
	        vis[node] = 1;
	        for(var it : adj.get(node)){
	            
	            int edWt = it.wt;
	            int adjNode = it.node;
	            if(vis[adjNode]!=1){
	                pq.add(new Tuple(adjNode,edWt));
	            }
	        }
	    }
	    return mst;
	}
}
class Tuple{
        int wt;
        int node;
        Tuple(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
}
