// Problem link : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

class Solution {
    private int helper(int src , List<List<Pair>> adj,int t,int n){
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (x,y) -> x.dist-y.dist);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int dist = p.dist;
            int node = p.node;
            
            for(var it : adj.get(node)){
                int adjNode = it.node;
                int edWt = it.dist;
                
                if(distance[adjNode] > edWt + dist){
                    distance[adjNode] = edWt + dist;
                    pq.add(new Pair(adjNode,distance[adjNode]));
                }
            }
        }
        int cnt = 0; 
        for(int i =0 ; i < n ; i++){
            if(i!=src && distance[i]<=t){
                cnt++;
            }
        }
        return cnt;
    }
    public int findTheCity(int n, int[][] edges, int t) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;  i < edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int mini = Integer.MAX_VALUE;
        int ans = 0;
        for(int  i = 0 ; i < n ; i++){
            int temp = helper(i,adj,t,n);
            if(temp<=mini){
                mini = temp;
                ans = Math.max(ans,i);
            }
        }
        return ans;
    }
}
class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
