// Problem link : https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(var it : stones){
            maxRow = Math.max(maxRow,it[0]);
            maxCol = Math.max(maxCol,it[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(var it : stones){
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow+1;
            ds.unionByRank(nodeRow,nodeCol);
            hm.put(nodeRow,1);
            hm.put(nodeCol,1);
        }
        int cnt = 0;
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(ds.findUParent(entry.getKey()) == entry.getKey()){
                cnt++;
            }
        }
        System.out.println(maxCol);
        // ans = number of stones - number of connected components
        return n - cnt;
    }
}

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
