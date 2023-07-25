// Problem link : https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i =0 ; i <= n ; i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    
    public int findUParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u , int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else{
            parent.set(ulp_u,ulp_v);
            rank.set(ulp_v,rank.get(ulp_v)+1);
        }
        
    }
    
    public void unionBySize(int u , int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u) + size.get(ulp_u));
        }
        
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    DisjointSet ds = new DisjointSet(V);
	    int ans = 0 ;
	    Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });
	    for(var it : edges){
	        int u = it[0];
	        int v = it[1];
	        int wt = it[2];
	        
	        if( ds.findUParent(u) != ds.findUParent(v)){
	            ans += wt;
	            ds.unionByRank(u,v);
	        }
	    }
	    return ans;
	}
}
