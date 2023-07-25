// Problem link : https://practice.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int V){
        for(int i =0; i < V;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        return findUParent(parent.get(node));
    }
    public void unionByRank(int u,int v){
        int u_pu = findUParent(u);
        int u_pv = findUParent(v);
        if(u_pu==u_pv) return;
        if(rank.get(u_pu) > rank.get(u_pv)){
            parent.set(u_pv,u_pu);
        }
        else if(rank.get(u_pu) < rank.get(u_pv)){
            parent.set(u_pu,u_pv);
            
        }
        else{
            parent.set(u_pu,u_pv);
            rank.set(u_pv,rank.get(u_pv)+1);
        }
        
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        int num_provinces = 0;
        for(int i = 0; i < adj.size();i++){
            for(int j =0; j <adj.get(0).size();j++){
                if(adj.get(i).get(j)==1){
                    ds.unionByRank(i,j);
                }
            }
        }
        for(int i = 0 ; i< V;i++){
            if(ds.findUParent(i)==i){
                num_provinces++;
            }
        }
        return num_provinces;
    }
}
